package com.jetbrains.handson.chat.client

import com.jetbrains.handson.chat.client.OperatingParameters.Identity
import com.jetbrains.handson.chat.client.allClientsData.allClients
import com.jetbrains.handson.chat.client.allClientsData.clientData
import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
data class Message(
        @EncodeDefault val fromID: String = Identity.fingerprint,
        val toID: String,
        val data: String,
        val type: ApplicationDataType,
        @EncodeDefault val time: Long = System.currentTimeMillis()) {
    fun display() = when (type) {
        ApplicationDataType.TEXT -> TextMessageBox(data).display()
        ApplicationDataType.FILE -> println() //TODO impliment or remove
        ApplicationDataType.PING -> println()
        ApplicationDataType.CONFIG -> ConfigMessageBox(data).updateMembers()
    }
}



object Messages{
    val messages = mutableMapOf<Message, Boolean>()

    fun put(message: Message, read: Boolean = false): Boolean? = messages.put(message, read)
    //TODO Filter only text messages
    fun read(isRead : Boolean = false){
        for ((message, read) in messages) {
            if (read == isRead) message.display()
        }
    }


}


//List of all possible message type the app can receive
enum class ApplicationDataType {
    TEXT, FILE, PING, CONFIG;

    companion object {
        fun findDataType(name: String): ApplicationDataType {
            for (enum in values()) {
                if (enum.name.equals(name, true)) return enum
            }
            return PING
        }
    }
}

//TODO fix comment bellow
// abstract class for providing a framework for storing T data
abstract class MessageBox<T>(t: T) {
    val data = t
    open fun display() {
        TODO("The display function has not been created😒")
    }
}

class TextMessageBox(data: String) : MessageBox<String>(data) {
    override fun display() {
        println("Message from ...  : $data")
    }
}

class FileMessageBox(data: String) : MessageBox<String>(data) {

}

class PingMessageBox(ID: Int) : MessageBox<Int>(ID) {

}

class ConfigMessageBox(data: String) : MessageBox<String>(data) {
    fun updateMembers(){
        val newClientLis = Json.decodeFromString<List<clientData>>(data)
        allClients.listOf.removeAll { true }
        allClients.listOf.addAll(newClientLis)
    }
}