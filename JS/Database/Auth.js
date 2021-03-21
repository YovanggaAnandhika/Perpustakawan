import Config from "./../config"

const Auth = {

    Auth : async (request, callback) => {
        new DKA.Database.MariaDB(Config)
            .rawQuery("SELECT * FROM");
    }
}