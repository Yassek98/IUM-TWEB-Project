var socketIo = require('socket.io');

exports.init = function (server) {
    var io = socketIo(server);

    io.on('connection', function (socket) {
        console.log(`A user has connected with ID: ${socket.id}`);

        socket.on('joinRoom', function (room, username) {
            socket.join(room);
            socket.username = username;
            socket.room = room;
            updateRoomUserCount(io, room);

            socket.to(room).emit('newMessage', {
                sender: 'System',
                text: `${username} has joined the chat.`,
                timestamp: new Date().toLocaleTimeString(),
                type: 'notification'
            });
        });

        socket.on('chatMessage', function (room, username, message) {
            io.to(room).emit('newMessage', {
                sender: username,
                text: message,
                timestamp: new Date().toLocaleTimeString(),
                type: 'message'
            });
        });

        socket.on('leaveRoom', function () {
            const room = socket.room;
            const username = socket.username;
            socket.leave(room);
            updateRoomUserCount(io, room, true);

            io.to(room).emit('newMessage', {
                sender: 'System',
                text: `${username} has left the chat.`,
                timestamp: new Date().toLocaleTimeString(),
                type: 'notification'
            });
        });

        socket.on('disconnect', function () {
            if (socket.room && socket.username) {
                const room = socket.room;
                io.to(room).emit('newMessage', {
                    sender: 'System',
                    text: `${socket.username} has left the chat.`,
                    timestamp: new Date().toLocaleTimeString(),
                    type: 'notification'
                });
                updateRoomUserCount(io, room, true);
            }
        });
    });

    function updateRoomUserCount(io, room, isLeave = false) {
        const roomDetails = io.sockets.adapter.rooms.get(room);
        const numUsers = roomDetails ? roomDetails.size : (isLeave ? -1 : 0);
        io.to(room).emit('updateUserCount', numUsers);
    }
};