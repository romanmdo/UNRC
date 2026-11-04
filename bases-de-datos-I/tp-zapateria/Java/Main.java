import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        // Primero, le pasamos los correspondientes parametros
        // de la Base de Datos a nuestro Script.

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");     // Cargamos el Driver

            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tpbdd",       // URL JDBC
                "root",                                    // user JDBC
                "root"                                     // passwd JDBC
            );

            Scanner scanner = new Scanner(System.in);      // Creamos un scanner (Input en Java) 
            int opcion = 0;

            System.out.println("Script de control (Zapateria)! ");

            while (opcion != 4) {
                System.out.println("\nSeleccione la operación a ejecutar:");
                System.out.println("1. Insertar datos de proveedores.");
                System.out.println("2. Eliminar un proveedor dado su CUIT.");
                System.out.println("3. Listar todos proveedores.");
                System.out.println("4. Salir.");
                System.out.print("Opción elegida: ");

                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        // Le pasamos la conexión y el scanner al método
                        insertarProveedores(connection, scanner);
                        break;
                    case 2:
                        eliminarProveedor(connection, scanner);
                        break;
                    case 3:
                        listarProveedores(connection);
                        break;
                    case 4:
                        System.out.println("Se cierra el sistema");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente con un número del 1 al 4.");
                }
            }
            
            System.out.println("¡Conexión exitosa!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para insertar proveedores a 
     * nuestra Base de Datos.
     * @param connection
     * @param scan
     * @return void
     */
    public static void insertarProveedores(Connection connection, Scanner scan) {
        try {
            // Apagamos el autoguardado para iniciar 
            // la transacción manual.
            connection.setAutoCommit(false);

            // Limpiar el buffer residual del menú.
            scan.nextLine(); 
            
            // Nos guardamos el CUIT del Proveedor Ingresado.
            System.out.print("Ingrese el CUIT del Proveedor: ");
            String cuit = scan.nextLine();

            // Nos guardamos la Razón Social del Proveedor Ingresado.
            System.out.print("Ingrese la Razón Social del Proveedor: ");
            String razon_social = scan.nextLine();

            // Nos guardamos la Dirección del Proveedor Ingresado.
            System.out.print("Ingrese la Dirección del Proveedor: ");
            String direccion = scan.nextLine();

            // Nos guardamos el Telefono Fijo del Proveedor Ingresado.
            System.out.print("Ingrese el Telefono Fijo del Proveedor: ");
            String telefonoFijo = scan.nextLine();
            
            // Nos guardamos el Celular del Proveedor Ingresado.
            System.out.print("Ingrese el Celular del Proveedor: ");
            String celular = scan.nextLine();

            // Hacemos la primera consulta hacia
            // la tabla 'proveedor'.
            
            // Primera consulta SQL: Insertar datos en la tabla proveedor
            // Los '?' son para avisarle a la consulta que va a 
            // tener que usar valores que le pasamos por teclado.
            String query = "INSERT INTO proveedor (cuit, razon_social, direccion, telefono_fijo) VALUES (?, ?, ?, ?) ";
            
            // Retorna un nuevo objeto PreparedStatement,
            // el cual, representa la sentencia SQL (query).
            PreparedStatement pstmt = connection.prepareStatement(query);
            
            // El 1er '?' va a guardar el CUIT.
            pstmt.setString(1, cuit);

            // El 2do '?' va a guardar la Razón Social.
            pstmt.setString(2, razon_social);

            // El 3ro '?' va a guardar la Dirección.
            pstmt.setString(3, direccion);

            // El 4to '?' va a guardar el Telefono Fijo.
            pstmt.setString(4, telefonoFijo);

            // Ejecutamos la consulta, 
            // la cual va a modificar nuestra
            // Base de datos.
            pstmt.executeUpdate();

            // Liberamos los recursos que
            // estabamos utilizando
            pstmt.close();

            // Segunda consulta SQL: Insertar datos en la tabla mproveedor
            String query2 = "INSERT INTO mproveedor (cuit, celular) VALUES (?, ?) ";
            PreparedStatement pstmt2 = connection.prepareStatement(query2);
            
            pstmt2.setString(1, cuit);
            pstmt2.setString(2, celular);
            pstmt2.executeUpdate();
            
            // Confirmamos la transaccion, es decir,
            // hacemos permanentes los cambios en nuestra
            // Base de Datos.
            connection.commit();
           
        } catch (Exception e) {
            System.out.println("Error al intentar guardar. Deshaciendo cambios...");
            try {
                // En el caso de que algo falle, lo que
                // hacemos es revertir la transaccion.
                connection.rollback(); 
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                // Prendemos el autoguardado nuevamente
                connection.setAutoCommit(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Método para eliminar a un provedor
     * dado su CUIT por consola.
     * @param connection
     * @return void
     */
    public static void eliminarProveedor(Connection connection, Scanner scan)
    {
        try {
            // Limpiar el buffer residual del menú.
            scan.nextLine(); 

            connection.setAutoCommit(false);
            
            // Nos guardamos el CUIT del Proveedor Ingresado.
            System.out.print("Ingrese el CUIT del Proveedor: ");
            String cuitBuscado = scan.nextLine();

            // Creamos el statement.
           
            String query = "DELETE FROM proveedor WHERE cuit = ?";

            // Retorna un nuevo objeto PreparedStatement,
            // el cual, representa la sentencia SQL (query).
            PreparedStatement pstmt = connection.prepareStatement(query);
            
            // El 1er '?' va a guardar el CUIT.
            pstmt.setString(1, cuitBuscado);

            // Ejecutamos la consulta, 
            // la cual va a modificar nuestra
            // Base de datos.
            pstmt.executeUpdate();

            // Liberamos los recursos que
            // estabamos utilizando
            pstmt.close();
            connection.commit();

            System.out.print("Proveedor eliminado con exito!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método estatico para listar todos 
     * los proveedores que tengamos cargados
     * en nuestra base de datos.
     * @param connection
     * @return void
     */
    public static void listarProveedores(Connection connection)
    {
        try {
            System.out.println("Listado de proveedores: \n");
            
            // Creamos el statement.
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM proveedor";

            // Creamos el conjunto con los proveedores.
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) 
            {
                String cuit = resultSet.getString("cuit");
                String razonSocial = resultSet.getString("razon_social");
                String direccion = resultSet.getString("direccion");
                int telefono = resultSet.getInt("telefono_fijo"); 
            
                System.out.println("CUIT: " + cuit + " | Razón Social: " + razonSocial + " | Dir: " + direccion + " | Tel: " + telefono);
            }

            // Liberamos el resultSet.
            resultSet.close();

            // Liberamos el statement.
            statement.close();

        } catch (Exception e) {
            // En caso de que haya error, lo mostramos.
            e.printStackTrace();
        }   
    }

    

}