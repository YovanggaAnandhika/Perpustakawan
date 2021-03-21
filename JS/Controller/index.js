import Database from "./../Database"

const Controller = async(app, opts, next) => {

    await app.post("/auth", (request, response) => {

        new Promise(async (resolve, rejected) => {
            await Database.Auth(request, async (error, result, fields) => {
                (!error) ? resolve(result) : rejected(error)
            })
        }).then(async (resolve) => {

            (resolve.length > 0) ? await response.send({
                status : true,
                msg : "Data Berhasil Ditemukan",
                data : resolve[0]
            }) : await response.send({
                status : false,
                msg : "Data Tidak Ditemukan"
            })

        }).catch(async (rejected) => {
            await response.send({
                status : false,
                msg : rejected
            })
        });

    })
    await next();
};


export default Controller;