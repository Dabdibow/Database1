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
        response.send(JSON.stringify(result));
    });
};