package main;

import integration.database.mysql.MySqlOperations;
import org.apache.log4j.PropertyConfigurator;
import java.sql.SQLException;
import static util.enums.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static util.enums.SystemProperties.USER_DIR;
import java.util.Scanner;

public class Main {

    private static final String SERVER = "localhost:3306";
    private static final String DATA_BASE_NAME = "haroldCalderon_empresaDeTalleresParaVehiculos_10092021";
    private static final String USER = "root";
    private static final String PASSWORD = "toor";
    private static final MySqlOperations mySqlOperations = new MySqlOperations();
    private static final String SELECT_ALL_FROM_EMPLEADO_BOGOTA = String.format("SELECT * FROM empleadosBogotaView", DATA_BASE_NAME);
    private static final String SELECT_ALL_FROM_EMPLEADO_MEDELLIN = String.format("SELECT * FROM empleadosMedellinView", DATA_BASE_NAME);
    private static final String SELECT_ALL_FROM_EMPLEADO_CALI = String.format("SELECT * FROM empleadosCaliView", DATA_BASE_NAME);
    private static final String SELECT_ALL_FROM_EMPLEADO_BARRANQUILLA = String.format("SELECT * FROM empleadosBarranquillaView", DATA_BASE_NAME);
    private static final String SELECT_ALL_FROM_EMPLEADO_CARTAGENA = String.format("SELECT * FROM empleadosCartagenaView", DATA_BASE_NAME);
    private static final String SELECT_ALL_FROM_EMPLEADO_SOACHA = String.format("SELECT * FROM empleadosSoachaView", DATA_BASE_NAME);
    private static final String SELECT_ALL_FROM_EMPLEADO_CUCUTA = String.format("SELECT * FROM empleadosCucutaView", DATA_BASE_NAME);
    private static final String SELECT_ALL_FROM_EMPLEADO_SOLEDAD = String.format("SELECT * FROM empleadosSoledadView", DATA_BASE_NAME);
    private static final String SELECT_ALL_FROM_EMPLEADO_BUCARAMANGA= String.format("SELECT * FROM empleadosBucaramagaView", DATA_BASE_NAME);
    private static final String SELECT_ALL_FROM_EMPLEADO_BELLO = String.format("SELECT * FROM empleadosBelloView", DATA_BASE_NAME);
    private static final String CALL_SP_INSERTAR_PROPIETARIO = String.format("CALL sp_insertarPropietario(1030656516,1,'Harold','Yesid','Calderon','Vega','cll','4','A','51',null,'harold.1408@hotmail.com','9000940','1995-08-14')", DATA_BASE_NAME);
    private static final String CALL_SP_Borrar_PROPIETARIO = String.format("CALL sp_eliminarPropietario()", DATA_BASE_NAME);
    private static final String CALL_SP_PROPIETARIOS = String.format("CALL sp_propietarios()", DATA_BASE_NAME);
    private static final String CALL_SP_CONSULTAR_REVISIONES = String.format("CALL sp_colsultarRevisiones()", DATA_BASE_NAME);
    private static final String CALL_SP_ACTUALIZAR_HORA = String.format("sp_actualizarHoraRevision(3,'7:00:00')", DATA_BASE_NAME);


    /*private static final String SELECT_ALL_FROM_CIUDAD = String.format("select * from %s.ciudad", DATA_BASE_NAME);
    private static final String SELECT_ALL_FROM_DIRECTOR= String.format("select * from %s.director", DATA_BASE_NAME);
    private static final String CALL_SP_LISTAR_PELICULAS= String.format("call sp_listar_peliculas()");

    private static final MySqlOperations mySqlOperations = new MySqlOperations();
    */
    public static void main(String[] args) throws Exception {
        PropertyConfigurator.configure(USER_DIR.getValue() + LOG4J_PROPERTIES_FILE_PATH.getValue());
        Scanner scan = new Scanner(System.in);
        String entrada="";
        while (true){
            System.out.println("Que deseas hacer");
            System.out.println("1) Verificar Empleados por ciudades");
            System.out.println("2) Insertar propietario predeterminado");
            System.out.println("3) Borrar propietario predeterminado");
            System.out.println("4) Listar propietarios");
            System.out.println("5) Consultar revisiones en proceso");
            System.out.println("6) Actualizar hora de cita para revision predeterminada");
            System.out.println("7) Salir");

            entrada=scan.nextLine();
            if (entrada.equals("1")){
                System.out.println("1) Bogota");
                System.out.println("2) Medellin");
                System.out.println("3) Cali");
                System.out.println("4) Barranquilla");
                System.out.println("5) Cartagena");
                System.out.println("6) Soacha");
                System.out.println("7) Cucuta");
                System.out.println("8) Soledad");
                System.out.println("9) Bucaramaga");
                System.out.println("10) Bello");
                entrada=scan.nextLine();
                    if (entrada.equals("1")) {
                        login();
                        selectAllEMPLEADOBOGOTA();
                        logout();
                    }else if (entrada.equals("2")) {
                        login();
                        selectAllEMPLEADOMEDELLIN();
                        logout();
                    }else if (entrada.equals("3")) {
                        login();
                        selectAllEMPLEADOCALI();
                        logout();
                    }else if (entrada.equals("4")) {
                        login();
                        selectAllEMPLEADOBARRANQUILLA();
                        logout();
                    }else if (entrada.equals("5")) {
                        login();
                        selectAllEMPLEADOCARTAGENA();
                        logout();
                    }else if (entrada.equals("6")) {
                        login();
                        selectAllEMPLEADOSOACHA();
                        logout();
                    }else if (entrada.equals("7")) {
                        login();
                        selectAllEMPLEADOCUCUTA();
                        logout();
                    }else if (entrada.equals("8")) {
                        login();
                        selectAllEMPLEADOSOLEDAD();
                        logout();
                    }else if (entrada.equals("9")) {
                        login();
                        selectAllEMPLEADOBUCARAMANGA();
                        logout();
                    }else if (entrada.equals("10")) {
                        login();
                        selectAllEMPLEADOBELLO();
                        logout();
                    }else {
                        System.out.println("No existe opcion");
                    }
                    System.out.println("*********************************************");
            }
            else if (entrada.equals("2")){
                login();
                call_sp_insertarPropietario();
                logout();
                System.out.println("Insertado");
                System.out.println("*********************************************");
            }
            else if (entrada.equals("3")) {
                login();
                call_sp_borrarPropietario();
                logout();
                System.out.println("Borrado");
                System.out.println("*********************************************");
            }
            else if (entrada.equals("4")){
                login();
                call_sp_listarPropietario();
                logout();
                System.out.println("*********************************************");
            }
            else if (entrada.equals("5")){
                login();
                call_sp_consultarRevisiones();
                logout();
                System.out.println("*********************************************");
            }
            else if (entrada.equals("6")){
                login();
                call_sp_actualizarHora();
                logout();
                System.out.println("*********************************************");
            }else if (entrada.equals("7")) {
                break;
            }
            else{
                System.out.println("No existe opcion");
            }
        }
    }

    private static void login(){
        mySqlOperations.setServer(SERVER);
        mySqlOperations.setDataBaseName(DATA_BASE_NAME);
        mySqlOperations.setUser(USER);
        mySqlOperations.setPassword(PASSWORD);
    }
    private static void logout(){
        mySqlOperations.close();
    }
    private static void selectAllEMPLEADOBOGOTA() throws SQLException {
        mySqlOperations.setSqlStatement(SELECT_ALL_FROM_EMPLEADO_BOGOTA);
        mySqlOperations.executeSqlStatement();
        mySqlOperations.printResultSet();
    }
    private static void selectAllEMPLEADOMEDELLIN() throws SQLException {
        mySqlOperations.setSqlStatement(SELECT_ALL_FROM_EMPLEADO_MEDELLIN);
        mySqlOperations.executeSqlStatement();
        mySqlOperations.printResultSet();
    }
    private static void selectAllEMPLEADOCALI() throws SQLException {
        mySqlOperations.setSqlStatement(SELECT_ALL_FROM_EMPLEADO_CALI);
        mySqlOperations.executeSqlStatement();
        mySqlOperations.printResultSet();
    }
    private static void selectAllEMPLEADOBARRANQUILLA() throws SQLException {
        mySqlOperations.setSqlStatement(SELECT_ALL_FROM_EMPLEADO_BARRANQUILLA);
        mySqlOperations.executeSqlStatement();
        mySqlOperations.printResultSet();
    }
    private static void selectAllEMPLEADOCARTAGENA() throws SQLException {
        mySqlOperations.setSqlStatement(SELECT_ALL_FROM_EMPLEADO_CARTAGENA);
        mySqlOperations.executeSqlStatement();
        mySqlOperations.printResultSet();
    }
    private static void selectAllEMPLEADOSOACHA() throws SQLException {
        mySqlOperations.setSqlStatement(SELECT_ALL_FROM_EMPLEADO_SOACHA);
        mySqlOperations.executeSqlStatement();
        mySqlOperations.printResultSet();
    }
    private static void selectAllEMPLEADOCUCUTA() throws SQLException {
        mySqlOperations.setSqlStatement(SELECT_ALL_FROM_EMPLEADO_CUCUTA);
        mySqlOperations.executeSqlStatement();
        mySqlOperations.printResultSet();
    }
    private static void selectAllEMPLEADOSOLEDAD() throws SQLException {
        mySqlOperations.setSqlStatement(SELECT_ALL_FROM_EMPLEADO_SOLEDAD);
        mySqlOperations.executeSqlStatement();
        mySqlOperations.printResultSet();
    }
    private static void selectAllEMPLEADOBUCARAMANGA() throws SQLException {
        mySqlOperations.setSqlStatement(SELECT_ALL_FROM_EMPLEADO_BUCARAMANGA);
        mySqlOperations.executeSqlStatement();
        mySqlOperations.printResultSet();
    }
    private static void selectAllEMPLEADOBELLO() throws SQLException {
        mySqlOperations.setSqlStatement(SELECT_ALL_FROM_EMPLEADO_BELLO);
        mySqlOperations.executeSqlStatement();
        mySqlOperations.printResultSet();
    }
    private static void call_sp_insertarPropietario() throws SQLException {
        mySqlOperations.setSqlStatement(CALL_SP_INSERTAR_PROPIETARIO);
        mySqlOperations.executeSqlStatement();
        mySqlOperations.printResultSet();
    }
    private static void call_sp_borrarPropietario() throws SQLException {
        mySqlOperations.setSqlStatement(CALL_SP_Borrar_PROPIETARIO);
        mySqlOperations.executeSqlStatement();
        mySqlOperations.printResultSet();
    }
    private static void call_sp_listarPropietario() throws SQLException {
        mySqlOperations.setSqlStatement(CALL_SP_PROPIETARIOS);
        mySqlOperations.executeSqlStatement();
        mySqlOperations.printResultSet();
    }
    private static void call_sp_consultarRevisiones() throws SQLException {
        mySqlOperations.setSqlStatement(CALL_SP_CONSULTAR_REVISIONES);
        mySqlOperations.executeSqlStatement();
        mySqlOperations.printResultSet();
    }
    private static void call_sp_actualizarHora() throws SQLException {
        mySqlOperations.setSqlStatement(CALL_SP_ACTUALIZAR_HORA);
        mySqlOperations.executeSqlStatement();
        //mySqlOperations.printResultSet();
    }


}
