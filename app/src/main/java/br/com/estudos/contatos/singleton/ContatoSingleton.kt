package br.com.estudos.contatos.singleton

import br.com.estudos.contatos.model.ContatosVO


object ContatoSingleton {
    var lista: MutableList<ContatosVO> = mutableListOf()
}