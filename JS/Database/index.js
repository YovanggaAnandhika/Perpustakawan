import DKA from "dkaframework"
import Config from "./../config"

const Index = {

    Auth : async (request, callback) => {
        const sql = "SELECT * FROM `dka-project_perpustakawan`.`user` WHERE username = ? AND password = ?";
        new DKA.Database.MariaDB(Config).rawQuery(sql, [ request.username, request.password ], callback);
    },
    Buku : {
        Detail : async (request, callback) => {
            const sql = "SELECT * FROM `dka-project_perpustakawan`.`buku`";
            new DKA.Database.MariaDB(Config).rawQuery(sql, [], callback);
        },
        Kategori : async (request, callback) => {
            const sql = "SELECT * FROM `dka-project_perpustakawan`.`kategori`";
            new DKA.Database.MariaDB(Config).rawQuery(sql, [], callback);
        }
    },
    Detail : async (request, callback) => {
        const sql = "SELECT * FROM `dka-project_perpustakawan`.`peminjaman`";
        new DKA.Database.MariaDB(Config).rawQuery(sql, [], callback);
    },
}

export default Index;