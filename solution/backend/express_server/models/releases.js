const mongoose = require('mongoose');

const releasesSchema = new mongoose.Schema({
    id: { type: Number, required: true },
    country: { type: String, required: true },
    date: { type: Date, required: true },
    type: { type: String, required: true },
    rating: { type: String }
});

const Releases = mongoose.model('Releases', releasesSchema);

module.exports = Releases;