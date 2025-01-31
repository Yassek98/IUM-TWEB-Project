const express = require('express');
const exphbs = require('express-handlebars');
const path = require('path');

var indexRouter = require('./routes/index');
//var usersRouter = require('./routes/users');

const app = express();

app.engine('hbs', exphbs.engine({ 
    extname: '.hbs',
    partialsDir: path.join(__dirname, 'views', 'partials'),
    layoutsDir: path.join(__dirname, 'views', 'layouts')
}));
app.set('view engine', 'hbs');
app.set('views', path.join(__dirname, 'views'));

app.use(express.static(path.join(__dirname, 'public')));
app.use(express.json());

app.use('/', indexRouter);

// error handler
app.use(function(err, req, res, next) {
    res.locals.message = err.message;
    res.locals.error = req.app.get('env') === 'development' ? err : {};
  
    res.render('error');
});

module.exports = app;
