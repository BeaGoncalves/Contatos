package br.com.estudos.contatos.contato

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.estudos.contatos.R
import br.com.estudos.contatos.bases.BaseActivity
import br.com.estudos.contatos.databinding.ActivityContatoBinding
import br.com.estudos.contatos.model.ContatosVO
import br.com.estudos.contatos.singleton.ContatoSingleton

class ContatoActivity : BaseActivity() {

    private var idContato: Int = -1
    lateinit var binding: ActivityContatoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContatoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setToolbar(binding.toolBar, "Novo contato")
        setupContato()
        binding.btnSalvarConato.setOnClickListener { onClickSalvarContato() }
    }

    private fun onClickSalvarContato(){

        val telefone = binding.etTelefone.text.toString()
        val nome = binding.etNome.text.toString()
        val contato = ContatosVO(
            idContato,
            nome,
            telefone
        )
        if (idContato == -1) {
            ContatoSingleton.lista.add(contato)
        } else {
            ContatoSingleton.lista.set(idContato, contato)
        }
        finish()
    }

    fun onClickExcluirContato(view: View){
     if (idContato > -1){
         ContatoSingleton.lista.removeAt(idContato)
         finish()
     }

    }

    private fun setupContato() {
        idContato = intent.getIntExtra("index", -1)
        if (idContato == -1){
            binding.btnExcluirContato.visibility = View.GONE
            return
        }
        binding.etNome.setText(ContatoSingleton.lista[idContato].nome)
        binding.etTelefone.setText(ContatoSingleton.lista[idContato].telefone)
    }
}