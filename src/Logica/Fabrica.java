/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


/**
 *
 * @author ninoh
 */
public class Fabrica {

    //SINGLETON
    private static Fabrica instancia;
    private static IContUsuario Usuario;


    public static Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();
        }
        return instancia;

    }

    public static IContUsuario getUsuario() {
        Usuario = ControladorUsuarios.getInstance();
        return Usuario;
    }
    private Fabrica() {
        this.getUsuario();
    }

        
}

