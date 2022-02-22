import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.estudos.contatos.R
import br.com.estudos.contatos.model.ContatosVO
import br.com.estudos.contatos.databinding.ItemListBinding

class ContatoAdapter(

    private val context: Context,
    private val lista: List<ContatosVO>,
    private val onClick: ((Int) -> Unit)
) : RecyclerView.Adapter<ContatoAdapter.ContatosViewHolder>() {
        class ContatosViewHolder(var binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatosViewHolder {
        return ContatosViewHolder(ItemListBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: ContatosViewHolder, position: Int) {
        val contato = lista[position]
        holder.binding.apply {
            textNome.text = contato.nome
            textNumero.text = contato.telefone
            llItem.setOnClickListener { onClick(contato.id) }
        }
    }

    override fun getItemCount(): Int = lista.size

}
