document.addEventListener("DOMContentLoaded", function () {
    const socket = io();
    let username = "";
    let room = window.location.pathname.split("/").pop();

    const chatOpenButton = document.querySelector(".chat-open");
    const chatCloseButton = document.querySelector(".chat-close");
    const usernameInput = document.querySelector(".username-input");
    const chatUsername = document.querySelector(".chat-username");
    const chatBox = document.querySelector(".chat-box");

    chatOpenButton.addEventListener("click", function () {
        username = usernameInput.value.trim();
        if (username) {
            chatUsername.style.display = "none";
            chatBox.style.display = "block";
            socket.emit("joinRoom", room, username);
        }
    });

    chatCloseButton.addEventListener("click", function () {
        socket.emit('leaveRoom');  // Sends a custom event before disconnecting
        chatBox.style.display = "none";
        chatUsername.style.display = "block";
        usernameInput.value = '';
        usernameInput.focus();
    });

    document.querySelector(".send").addEventListener("click", function () {
        sendMessage();
    });

    document.querySelector(".chat-input textarea").addEventListener("keypress", function (event) {
        if (event.key === "Enter" && !event.shiftKey) {
            event.preventDefault();
            sendMessage();
        }
    });

    function sendMessage() {
        const messageInput = document.querySelector(".chat-input textarea");
        const messageText = messageInput.value.trim();
        if (messageText !== "") {
            socket.emit("chatMessage", room, username, messageText);
            messageInput.value = ""; // Clears the input after sending
        }
    }

    document.querySelector(".send").addEventListener("click", function () {
        sendMessage();
    });

    document.querySelector(".chat-input textarea").addEventListener("keypress", function (event) {
        if (event.key === "Enter" && !event.shiftKey) {
            event.preventDefault();
            sendMessage();
        }
    });

    socket.on("newMessage", function (data) {
        const chatBody = document.querySelector(".chat-body");
        const messageRow = document.createElement("div");
        messageRow.classList.add("chat-row", data.sender === username ? "me" : "target");

        const contentDiv = document.createElement("div");
        contentDiv.classList.add("chat-content");

        if (data.type === 'message') {
            const nameTag = document.createElement("div");
            nameTag.classList.add("chat-sender-name");
            nameTag.textContent = data.sender;
            contentDiv.appendChild(nameTag);
        }

        const messageDiv = document.createElement("div");
        messageDiv.classList.add("chat-message");
        messageDiv.textContent = data.text;

        const timeDiv = document.createElement("div");
        timeDiv.classList.add("chat-at");
        timeDiv.textContent = data.timestamp;

        contentDiv.appendChild(messageDiv);
        contentDiv.appendChild(timeDiv);
        messageRow.appendChild(contentDiv);

        chatBody.appendChild(messageRow);
        chatBody.scrollTop = chatBody.scrollHeight;
    });

    socket.on("updateUserCount", function(count) {
        const chatHeaderTitle = document.querySelector('.chat-header-title');
        chatHeaderTitle.textContent = `Room ID: ${room} - Connected users: ${count}`;
    });

});