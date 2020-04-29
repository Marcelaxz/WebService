package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            new Servidor().run(new String[]{"server"});
        } catch (Exception ex) {
            System.out.printf("Problema ao subir o servidor");
            ex.printStackTrace();
        }
    }
}
