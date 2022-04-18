import React, { useEffect, useState, Component } from "react";
import { over } from "stompjs";
import SockJS from "sockjs-client";


var stompClient=null;
    //BROWSER=none
const ChatRoom = () => {

    const [publicChats, setPublicChats] = useState([]); //empty array
    
    const [privateChats, setPrivateChats] = useState(new Map());

    const [tab, setTab] = useState("CHATROOM");      //CHATROOM OR PARTICULAR USER 

    //it holds all the details regarding the state
    const [userData, setUserData] = useState({
        username:"",
        recievername:"",
        connected:false,
        message:""
    });
    
    const handleUsername =(event)=>{
        const {value} = event.target;
        setUserData({...userData,"username":value}); //keeping other data as it is therefore there are 3 dots
    }

    
    const handleValue =(event)=>{
        const {value,name} = event.target;
        setUserData({...userData,[name]:value}); //keeping other data as it is therefore there are 3 dots
    }
    
    const handleMessage =(event)=>{
        const {value} = event.target;
        setUserData({...userData,"message":value}); //keeping other data as it is therefore there are 3 dots
    }



    const registerUser = ()=>{  //24:40
        let Sock = new SockJS("http://localhost:8080/ws");
        stompClient=over(Sock);
        stompClient.connect({},onConnected, onError); 
    }

    const onConnected = () => {
        setUserData({...userData,"connected":true});
        stompClient.subscribe('/chatroom/public',onPublicMessageRecieved);
        stompClient.subscribe('/user/'+userData.username+'/private',onPrivateMessageRecieved);

       userJoin();

    }

    const userJoin =()=>{
                let chatMessage={
                    senderName:userData.username,
                    status:"JOIN"
                };
                stompClient.send('/app/message', {}, JSON.stringify(chatMessage));
    }

    const onError =(err)=>{
        console.log(err); 
    }


    const onPublicMessageRecieved = (payload)=>{//28:00
        let payloadData=JSON.parse(payload.body);

        //enum from java
        switch(payloadData.status){
            case "JOIN":
                if(!privateChats.get(payloadData.senderName)){
                    privateChats.set(payloadData.senderName,[]);
                    setPrivateChats(new Map(privateChats));
                }
                break;
            case "MESSAGE": //29:00
                //we'll use array
                publicChats.push(payloadData);
                setPublicChats([...publicChats]);
                break;
        }
    }

    const onPrivateMessageRecieved =(payload)=>{    //30:00
         //we'll use map    where key is the username   and value is the list of messages sent by particular users
        //console.log(payload);
        let payloadData=JSON.parse(payload.body);
       // console.log(chatMessage);
        if(privateChats.get(payloadData.senderName)){
            //trial
            privateChats.get(payloadData.senderName).push(payloadData);
            //privateChats.get(payloadData.senderName, payloadData);   
            setPrivateChats(new Map(privateChats));
        }else{  //when sender name is not present in the map
            let list = [];
            list.push(payloadData);
            //list is the array of meesages
            privateChats.set(payloadData.senderName,list);
            setPrivateChats(new Map(privateChats));
        }
    }


    const sendPublicMessage=()=>{
        if(stompClient){
            let chatMessage={
                senderName:userData.username,
                message:userData.message,
                status:"MESSAGE"
            };
            console.log(chatMessage);
            stompClient.send('/app/message',{},JSON.stringify(chatMessage));
            setUserData({...userData,"message":""}); 
        }
        //this.showNotification
    }

    
    const sendPrivateMessage=()=>{
        if(stompClient){
            let chatMessage={
                senderName:userData.username,
                recieverName:tab,
                message:userData.message,
                status:"MESSAGE"
            }; 
 
            if(userData.username !== tab){
                 //trial
                //privateChats.set(tab).push(chatMessage);
                //privateChats.set(tab,chatMessage);
                privateChats.get(tab).push(chatMessage);
                setPrivateChats(new Map(privateChats));
                console.log(chatMessage);
            }
            console.log(chatMessage);
            stompClient.send('/app/private-message',{},JSON.stringify(chatMessage));
            setUserData({...userData,"message":""}); 
        }
     //   this.showNotification
    }

    //re-render after some time
    const [time, setTime] = useState(Date.now());
    useEffect(() => {
        const interval = setInterval(() => setTime(Date.now()), 1000);
        return () => {
          clearInterval(interval);
        };
      }, []);
    
    




class SimpleNotification extends Component {
  constructor() {
    super();
    this.showNotification = this.showNotification.bind(this);
  }
  componentDidMount() {
    if (!("Notification" in window)) {
      console.log("This browser does not support desktop notification");
    } else {
      Notification.requestPermission();
    }
  }
  showNotification() {
    new Notification('Hey')
  }
  render() {
    return (
      <div>
        <button onClick={this.showNotification}>
          Click to show notification
        </button>
      </div>
    );
  }
}





    //ternaryoperator in container class
    //classes have been defined in the index.css file
    return (
        
        <div className="container">
            <li onClick={()=>{}} className={`member`}><a href="http://localhost:8080">LOGOUT</a></li>
            {userData.connected?
            <div className="chat-box">    
                <div className="member-list">
                        <ul>
                            <li><h3>Talk with:</h3></li>
                            <li onClick={()=>{setTab("CHATROOM")}} className={`member ${tab==="CHATROOM" && "active"}`}>Chatroom</li>
                            {useEffect && [...privateChats.keys()].map((name,index)=>(
                                <li onClick={()=>{setTab(name); setTime()}} className={`member ${tab===name && "active"}`} key={index}>{name}</li>
                            ))} 
                        </ul>
                    </div>
                    {tab==="CHATROOM" && <div className="chat-content">
                        <ul className="chat-messages">
                        {publicChats.map((chat,index)=>(
                                <li className={`message ${chat.senderName === userData.username && "self"}`} key={index}>
                                    {chat.senderName !==userData.username && <div className="avatar">{chat.senderName}</div>}
                                    <div className="message-data">{chat.message}</div>                               
                                    {chat.senderName === userData.username && <div className="avatar self">{chat.senderName}</div>}
                                </li>
                            ))} 
                        </ul>

                        <div className="send-message">
                            <input type="text" className="input-message" placeholder="enter public message" value={userData.message} onChange={handleMessage} />
                            <button type="button" className="send-button" onClick={sendPublicMessage}>send</button>  
                        </div>
                    </div>}
                    
                    {tab!=="CHATROOM" && <div className="chat-content">
                    <ul className="chat-messages">
                        {[...privateChats.get(tab)].map((chat,index)=>(
                                <li className={`message ${chat.senderName === userData.username && "self"}`} key={index}>
                                    {chat.senderName !==userData.username && <div className="avatar">{chat.senderName}</div>}
                                    <div className="message-data">{chat.message}</div>                               
                                    {chat.senderName === userData.username && <div className="avatar self">{chat.senderName}</div>}
                                </li>
                            ))} 
                            </ul>

                        <div className="send-message">
                            <input type="text" className="input-message" placeholder={"enter private message"} value={userData.message} onChange={handleMessage} />
                            <button type="button" className="send-button" onClick={sendPrivateMessage}>Send</button>  
                        </div>

                    </div>}

            </div>
            :
            <div className="register">
                <input
                    id="user-name"
                    name="username"
                    placeholder="Enter Alias here"
                    value={userData.username}
                    onChange={handleUsername}
                  />
                    <button type="button"  onClick={registerUser}>
                        Connect
                    </button>
            </div>}
        </div>
    )
}

export default ChatRoom
    