
package interfaces;

import clases.Arriendo;
import clases.Cliente;
import clases.Cuota;
import controladores.Arriendos;
import controladores.Clientes;
import controladores.Vehiculos;
import java.util.ArrayList;


public class PagarCuotas extends javax.swing.JFrame {


    public PagarCuotas() {
        initComponents();
        this.setJComboBox1Model();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("PAGAR CUOTAS ARRIENDOS");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione CLIENTE" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione ARRIENDO" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciones CUOTA" }));

        button1.setLabel("Pagar cuota");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setLabel("Volver a la interfaz anterior");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(123, 123, 123))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        int stateChange = evt.getStateChange();
        if (stateChange == 2) {
            return;
        }
        
        if (jComboBox1.getSelectedIndex() == 0) {
            return;
        }

        String cedula = evt.getItem().toString();
        Cliente cliente = clientes.buscar(cedula);
        
        
        ArrayList<String> options = new ArrayList<>();
        options.add("Seleccione ARRIENDO");
        for (Arriendo arriendo: arriendos.arrayList) {
            if (arriendo.getCliente().getCedula().equals(cedula)) {
                options.add(arriendo.getNumArriendo() + "");
            }
        }
        String[] array = options.toArray(String[]::new);
        javax.swing.DefaultComboBoxModel<String> model = new javax.swing.DefaultComboBoxModel<>(array);
        jComboBox2.setModel(model);
        
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        if (jComboBox1.getSelectedIndex() == 0 || jComboBox2.getSelectedIndex() == 0 || jComboBox3.getSelectedIndex() == 0) {
            return;
        }
        
        String numArriendo = jComboBox2.getSelectedItem().toString();
        String numCuota = jComboBox3.getSelectedItem().toString();
        
        Arriendo arriendo = arriendos.buscar(numArriendo);
        arriendo.pagarCuota(Integer.parseInt(numCuota));
        arriendos.guardarEnFichero();


        ArrayList<String> options = new ArrayList<>();
        options.add("Seleccione CUOTA");
        for (Cuota cuota: arriendo.getCuotas()) {
            if (!cuota.getPagada()) {
                options.add(cuota.getId());
            }
        }
        String[] array = options.toArray(String[]::new);
        javax.swing.DefaultComboBoxModel<String> model = new javax.swing.DefaultComboBoxModel<>(array);
        jComboBox3.setModel(model);
        
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        Arrendar frameArrendar = new Arrendar();
        frameArrendar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button2ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        int stateChange = evt.getStateChange();
        if (stateChange == 2) {
            return;
        }
        
        if (jComboBox2.getSelectedIndex() == 0) {
            return;
        }

        String numArriendo = evt.getItem().toString();
        Arriendo arriendo = arriendos.buscar(numArriendo);
        
        
        ArrayList<String> options = new ArrayList<>();
        options.add("Seleccione CUOTA");
        for (Cuota cuota: arriendo.getCuotas()) {
            if (!cuota.getPagada()) {
                options.add(cuota.getId());
            }
        }
        String[] array = options.toArray(String[]::new);
        javax.swing.DefaultComboBoxModel<String> model = new javax.swing.DefaultComboBoxModel<>(array);
        jComboBox3.setModel(model);
    }//GEN-LAST:event_jComboBox2ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    private Clientes clientes = new Clientes();
    private Vehiculos vehiculos = new Vehiculos();
    private Arriendos arriendos = new Arriendos();

    
    private void setJComboBox1Model(){
        ArrayList<String> options = new ArrayList<>();
        options.add("Seleccione CLIENTE");
        for (Cliente cliente: clientes.arrayList) {
            if (cliente.getVigente()) {
                options.add(cliente.getCedula());
            }
        }
        String[] array = options.toArray(String[]::new);
        javax.swing.DefaultComboBoxModel<String> model = new javax.swing.DefaultComboBoxModel<>(array);
        jComboBox1.setModel(model);
    }


}
