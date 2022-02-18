package br.com.estudos.contatos.application

import android.app.Application
import android.database.sqlite.SQLiteDatabase
import br.com.estudos.contatos.helper.HelperDB
import br.com.estudos.contatos.model.ContatosVO

class ContatoApplication : Application() {

    companion object {
        lateinit var instance : ContatoApplication
    }

    var helperDB:HelperDB? = null
        private set

    override fun onCreate() {
        helperDB = HelperDB(this)
        instance = this
        super.onCreate()
    }


}