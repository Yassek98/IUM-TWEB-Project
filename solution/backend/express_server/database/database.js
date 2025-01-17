const mongoose = require('mongoose');

const url = "mongodb://localhost:27017/MongoTWEB";
mongoose.Promise = global.Promise;
connection = mongoose.connect(url, {family:4})
    .then(() => {
        console.log('successfully connected to MongoDB');
    })
    .catch((error) => {
        console.log('failed connection to MongoDB' + JSON.stringify(error));
    });