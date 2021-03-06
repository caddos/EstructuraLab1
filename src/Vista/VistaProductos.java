/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ProductosDAO;
import Modelo.Productos;
import Controlador.FileProductosDAO;
import Controlador.FileTipo_productosDAO;
import Controlador.Tipo_productosDAO;
import Modelo.Tipo_productos;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author carloscarrascal
 */
public class VistaProductos extends javax.swing.JFrame {
    
    Productos p;
    ProductosDAO pDAO;
    Tipo_productosDAO tpDAO = new FileTipo_productosDAO();
    List<Tipo_productos> tipoProductos= tpDAO.getAllTipo_producto();

       public String getIDProducto (){
             {
             try{String id_producto = field_id_producto.getText();
                return id_producto;
             }catch(Exception ex){
           return "Error";
                        }
                    }
       }
       
         public String getColeccion (){
                {
                try{String coleccion = field_coleccion.getText();
                    return coleccion;
                }catch(Exception ex){
                return "Error";
                    }
                }
        }
         public String getTipoProductos (){
                {
                 try{String tipoProducto = (String) field_tipo_productos.getSelectedItem();
                    return tipoProducto;
                }catch(Exception ex){
                return "Error";
                                            }
                }
         }
         public int getPrecio (){
                {
                 try{int precio = Integer.parseInt(field_precio.getText());
                    return precio;
                }catch(Exception ex){
                return 999;
                        }
                    }
        }
         
         public String getImage (){
                {
                 try{String image = field_image.getText();
                    return image;
                }catch(Exception ex){
                return "Error";
                                            }
                }
         }
         
         public void registrarProductos(){
      p= new Productos(getIDProducto (),getImage (),getPrecio (),getColeccion (),getTipoProductos ());
      pDAO = new FileProductosDAO();
      if (pDAO.saveProductos(p)) {
            JOptionPane.showMessageDialog(null, "Se ha registrado correctamente el producto");
            } else{
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error. Contacte al administrador");
                }
      }
    /**
     * 
     * Creates new form VistaProductos
     */
    public VistaProductos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        field_coleccion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        field_id_producto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        field_precio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        field_image = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        field_tipo_productos = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tipo productos");

        jLabel2.setText("Coleccion");

        field_coleccion.setText("jTextField2");

        jLabel3.setText("Id Producto");

        field_id_producto.setText("jTextField3");
        field_id_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_id_productoActionPerformed(evt);
            }
        });

        jLabel4.setText("Precio");

        field_precio.setText("jTextField4");
        field_precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_precioActionPerformed(evt);
            }
        });

        jLabel5.setText("Image");

        field_image.setText("jTextField5");
        field_image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_imageActionPerformed(evt);
            }
        });

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        field_tipo_productos.setModel(new javax.swing.DefaultComboBoxModel<>(new String [] {""}));
        int i=0;
        for (i=0;i < tipoProductos.size();i++){
            field_tipo_productos.addItem(tipoProductos.get(i).getReferencia_tipo());

        }
        field_tipo_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_tipo_productosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(field_tipo_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(field_id_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field_coleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field_image, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(394, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field_tipo_productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field_coleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field_id_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(field_image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void field_precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_precioActionPerformed

    private void field_imageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_imageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_imageActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.registrarProductos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void field_tipo_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_tipo_productosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_tipo_productosActionPerformed

    private void field_id_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_id_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_id_productoActionPerformed

   
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField field_coleccion;
    private javax.swing.JTextField field_id_producto;
    private javax.swing.JTextField field_image;
    private javax.swing.JTextField field_precio;
    private javax.swing.JComboBox<String> field_tipo_productos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
