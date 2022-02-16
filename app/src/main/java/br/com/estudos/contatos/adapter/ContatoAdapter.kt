import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.estudos.contatos.model.ContatosVO
import br.com.estudos.contatos.databinding.ItemListBinding

class ContatoAdapter(
    private val context: Context,
    private val lista: List<ContatosVO>,
    private val onClick: ((Int) -> Unit)
) : RecyclerView.Adapter<ContatoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
        return ContatoViewHolder(ItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        val contato = lista[position]
        with(holder.binding){
            textNome.text = contato.nome
            textNumero.text = contato.telefone
            llItem.setOnClickListener { onClick(position) }
        }
    }

    override fun getItemCount(): Int = lista.size
}


class ContatoViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)
