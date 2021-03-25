import {Database} from "dkaframework"
import Config from "./../config"

const Index = {

    Auth : async (request, callback) => {
        const sql = "SELECT * FROM `dka-project_perpustakawan`.`user` WHERE username = ? AND password = ?";
        new Database.MariaDB(Config).rawQuery(sql, [ request.body.username, request.body.password ], callback);
    },
    Buku : {
        Detail : async (request, callback) => {
            const sql = "SELECT * FROM `dka-project_perpustakawan`.`buku`";
            new Database.MariaDB(Config).rawQuery(sql, [], callback);
        },
        Kategori : async (request, callback) => {
            const sql = "SELECT * FROM `dka-project_perpustakawan`.`kategori`";
            new Database.MariaDB(Config).rawQuery(sql, [], callback);
        }
    },
    Peminjaman : async (request, callback) => {
        const sql = "SELECT * FROM `dka-project_perpustakawan`.`peminjaman`";
        new Database.MariaDB(Config).rawQuery(sql, [], callback);
    },
}

export default Index;