const mongoose = require('mongoose');
const csv = require('csv-parser');
const fs = require('fs');
const path = require('path');
const Review = require('../models/reviews');

const url = "mongodb://127.0.0.1:27017/MongoTWEB";
mongoose.Promise = global.Promise;

// Connect to MongoDB
mongoose.connect(url)
    .then(() => {
        console.log('Successfully connected to MongoDB');
    })
    .catch((error) => {
        console.log('Failed to connect to MongoDB', error);
    });

