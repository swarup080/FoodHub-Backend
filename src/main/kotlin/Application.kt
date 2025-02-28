package com.swarup.foodhab

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.ktorm.database.Database

fun main() {
    embeddedServer(Netty, port = 37260, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
//    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
//        .start(wait = true)
}

fun Application.module() {
    // Initialize Database Connection
    val database = Database.connect(
        url = "jdbc:mysql://shortline.proxy.rlwy.net:37260/railway",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "QNkZzbvJrNSxHRwcJOHGjBAaGdwSwimI"
    )
//    val database = Database.connect(
//        url = "jdbc:mysql://localhost:3306/foodhubapp",
//        driver = "com.mysql.cj.jdbc.Driver",
//        user = "root",
//        password = "123456"
//    )
    configureSerialization()
    configureRouting()
}
