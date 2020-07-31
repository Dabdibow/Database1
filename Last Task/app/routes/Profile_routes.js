bodyParser = require('body-parser').json();
let fs = require('fs');

module.exports = function(app){
    app.get('/info', (request, response) => {
        let result = [{ "id" : 1,
            "info" : " Давыдов Антон "
        },
            {
                "id" : 2,
                "info" : " 19 лет "
            },
            {
                "id" : 3,
                "info" : " группа:11-901 "
            }];
        response.setHeader("Content-Type", "application/json");
        response.send(JSON.stringify(result));
    });

    app.post('/register', bodyParser, (request, response) => {
        let body = request.body;
        console.log(body);
        fs.readFile('forms.json', 'utf-8', function(err, data) {
            if (err) throw err;
            let arrayOfObjects = JSON.parse(data);
            arrayOfObjects.forms.push(body);


            fs.writeFile('forms.json', JSON.stringify(arrayOfObjects), 'utf-8', function(err) {
                if (err) throw err;
                console.log('Done!')
            })
        });
        response.redirect('/Profile.html');
    });

    app.get('/forms', (request, response) => {
        fs.readFile('forms.json', 'utf8', function(err, contents) {
            response.setHeader('Content-Type', 'application/json');
            response.send(contents);
        });
    });
};