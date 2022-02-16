package br.com.estudos.contatos.bases

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.estudos.contatos.R

open class BaseActivity : AppCompatActivity() {


   protected fun setToolbar(toolbar: androidx.appcompat.widget.Toolbar, title:String) {

       toolbar.title = title
       setSupportActionBar(toolbar)
   }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.home -> {
                this.onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}