const DKA = require("dkaframework");
import path from "path";
const Controller = require("./Controller");

new DKA.Server({
    serverEnabled: true,
    serverEngine: DKA.Server.FASTIFY_CORE_ENGINE,
    serverState: DKA.Server.SERVER_STATE_DEVELOPMENT,
    serverView: DKA.Server.VIEW_POV_EJS,
    serverHost: "localhost",
    serverPort: 8089,
    app: Controller,
    options: {
        layoutDir: path.join(__dirname, "Layout"),
        assetsDir: path.join(__dirname, "Assets")
    }
});