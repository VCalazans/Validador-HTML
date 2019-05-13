/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.view.table;

import static java.awt.JobAttributes.DestinationType.FILE;
import java.io.File;
import javax.swing.table.AbstractTableModel;
import trabalho1.model.ListaEncadeada;
import trabalho1.model.NoLista;
import trabalho1.model.TagEncontrada;

/**
 *
 * @authors William Mello e Victor Calazans
 */
public class ValidadorArquivosTable extends AbstractTableModel {
  
    private static final int COL_ARQUIVOS = 0;
    private static final int COL_LOCAL = 1;
    private ListaEncadeada<File> lista;

    public ValidadorArquivosTable(ListaEncadeada<File> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.obterComprimento();
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        NoLista<File> f = lista.obterNo(rowIndex);

        if (f.getInfo() != null) {
            if (columnIndex == COL_ARQUIVOS) {
                return f.getInfo().getName();
            } else if (columnIndex == COL_LOCAL) {
                return f.getInfo().getAbsolutePath();
            }
        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        String coluna = "";

        switch (column) {
            case COL_ARQUIVOS:
                coluna = "ARQUIVOS";
                break;
            case COL_LOCAL:
                coluna = "LOCAL";
                break;
            default:
                break;

        }

        return coluna;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == COL_ARQUIVOS) {
            return String.class;
        } else if (columnIndex == COL_LOCAL) {
            return String.class;
        }

        return null;
    }

  
}
