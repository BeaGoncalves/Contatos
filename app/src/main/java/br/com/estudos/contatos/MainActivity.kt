package br.com.estudos.contatos

import ContatoAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.estudos.contatos.application.ContatoApplication
import br.com.estudos.contatos.bases.BaseActivity
import br.com.estudos.contatos.contato.ContatoActivity
import br.com.estudos.contatos.databinding.ActivityMainBinding
import br.com.estudos.contatos.model.ContatosVO
import br.com.estudos.contatos.singleton.ContatoSingleton
import java.lang.Exception

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapter: ContatoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val toolbar = binding.toolbar
        setToolbar(toolbar, "Lista de contatos")

        setupRecyclerView()
        setupOnClicks()
    }



    private fun setupOnClicks() {
        binding.fab.setOnClickListener { onClickAdd() }
        binding.imageBusca.setOnClickListener { onClickBuscar() }
    }

    private fun onClickBuscar() {
        val busca = binding.editBusca.text.toString()
        var listaFiltrada: List<ContatosVO> = mutableListOf()
        try {
            listaFiltrada = ContatoApplication.instance.helperDB?.bucaContato(busca)?: mutableListOf()
        } catch (e : Exception) {
            e.printStackTrace()
        }
        adapter = ContatoAdapter(this, listaFiltrada) {onClickItemRecyclerView(it)}
        binding.recyclerView.adapter = adapter
        Toast.makeText(this, "Buscando por $busca", Toast.LENGTH_SHORT).show()
    }

    private fun onClickItemRecyclerView(index: Int) {
        val intent = Intent(this, ContatoActivity::class.java)
        intent.putExtra("index", index)
        startActivity(intent)

    }

    private fun onClickAdd() {
        startActivity(Intent(this, ContatoActivity::class.java))
    }

    private fun setupRecyclerView() {
       binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()
        onClickBuscar()
    }

}