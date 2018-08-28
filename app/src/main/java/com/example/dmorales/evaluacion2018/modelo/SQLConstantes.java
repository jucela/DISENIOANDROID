package com.example.dmorales.evaluacion2018.modelo;

public class SQLConstantes {
    public static String DB_PATH = "/data/data/com.example.dmorales.evaluacion2018/databases/";
    //public static String DB_NAME = "mydatabase.sqlite";
    public static String DB_NAME = "marcoasistencia.sqlite";

    public static String tablanacional = "nacional";
    public static String tablausuariolocal = "usuario_local";
    public static String tablafecharegistro = "fecha_registro";
    public static String tablafecharegistrotemporal = "fecha_registro_temporal";


    // TABLA SQLITE NACIONAL
    public static String nacional_nivel = "nivel";
    public static String nacional_cod_sede_reg ="cod_sede_reg";
    public static String nacional_cod_sede_prov ="cod_sede_prov";
    public static String nacional_cod_sede_distrital="cod_sede_distrital";
    public static String nacional_sede_region = "sede_region";
    public static String nacional_sede_provincia = "sede_provincia";
    public static String nacional_sede_distrital = "sede_distrital";
    public static String nacional_cod_local = "cod_local";
    public static String nacional_nom_local = "nom_local";
    public static String nacional_direccion = "direccion";
    public static String nacional_aula = "aula";
    public static String nacional_codigo = "codigo";
    public static String nacional_nombres = "nombres";
    public static String nacional_id_cargo = "id_cargo";
    public static String nacional_cargo = "cargo";
    public static String nacional_tipo_candidato = "tipo_candidato";
    public static String nacional_n_bungalow = "n_bungalow";
    public static String nacional_resp_bungalow = "resp_bungalow";

    //TABLA SQLITE USUARIO_LOCAL
    public static String usuario_local_id = "_id";
    public static String usuario_local_usuario = "usuario";
    public static String usuario_local_clave = "clave";
    public static String usuario_local_cod_local = "cod_local";
    public static String usuario_local_nom_local = "nom_local";
    public static String usuario_local_cod_sede_reg = "cod_sede_reg";
    public static String usuario_local_sede_region = "sede_region";
    public static String usuario_local_cod_nivel = "cod_nivel";
    public static String usuario_local_nom_nivel = "nom_nivel";
    public static String usuario_local_fase = "fase";

    public static String fecha_de_registro_id = "_id";
    public static String fecha_de_registro_nivel="nivel";
    public static String fecha_de_registro_cod_sede_reg="cod_sede_reg";
    public static String fecha_de_registro_cod_sede_prov="cod_sede_prov";
    public static String fecha_de_registro_cod_sede_distrital="cod_sede_distrital";
    public static String fecha_de_registro_sede_region="sede_region";
    public static String fecha_de_registro_sede_provincia="sede_provincia";
    public static String fecha_de_registro_sede_distrital="sede_distrital";
    public static String fecha_de_registro_cod_local="cod_local";
    public static String fecha_de_registro_nom_local = "nom_local";
    public static String fecha_de_registro_direccion = "direccion";
    public static String fecha_de_registro_aula = "aula";
    public static String fecha_de_registro_codigo = "codigo";
    public static String fecha_de_registro_nombres = "nombres";
    public static String fecha_de_registro_id_cargo="id_cargo";
    public static String fecha_de_registro_cargo="cargo";
    public static String fecha_de_registro_tipo_candidato="tipo_candidato";
    public static String fecha_de_registro_n_bungalow="n_bungalow";
    public static String fecha_de_registro_resp_bungalow="resp_bungalow";
    public static String fecha_de_registro_fecha_registro1="fecha_registro1";
    public static String fecha_de_registro_fecha_registro2="fecha_registro2";
    public static String fecha_de_registro_dia1 = "dia1";
    public static String fecha_de_registro_mes1 = "mes1";
    public static String fecha_de_registro_anio1 = "anio1";
    public static String fecha_de_registro_hora1 = "hora1";
    public static String fecha_de_registro_minuto1 = "minuto1";
    public static String fecha_de_registro_dia2 = "dia2";
    public static String fecha_de_registro_mes2 = "mes2";
    public static String fecha_de_registro_anio2 = "anio2";
    public static String fecha_de_registro_hora2 = "hora2";
    public static String fecha_de_registro_minuto2 = "minuto2";
    public static String fecha_de_registro_estado1 = "estado1";
    public static String fecha_de_registro_estado2 = "estado2";
    public static String fecha_de_registro_subido1 = "subido1";
    public static String fecha_de_registro_subido2 = "subido2";



    public static String fecha_de_registro_dia3 = "dia3";
    public static String fecha_de_registro_mes3 = "mes3";
    public static String fecha_de_registro_anio3 = "anio3";
    public static String fecha_de_registro_hora3 = "hora3";
    public static String fecha_de_registro_minuto3 = "minuto3";
    public static String fecha_de_registro_dia4 = "dia4";
    public static String fecha_de_registro_mes4 = "mes4";
    public static String fecha_de_registro_anio4 = "anio4";
    public static String fecha_de_registro_hora4 = "hora4";
    public static String fecha_de_registro_minuto4 = "minuto4";
    public static String fecha_de_registro_estado3 = "estado3";
    public static String fecha_de_registro_estado4 = "estado4";
    public static String fecha_de_registro_subido3 = "subido3";
    public static String fecha_de_registro_subido4 = "subido4";



    public static final String SQL_CREATE_TABLA_FECHA_REGISTRO =
            "CREATE TABLE " + tablafecharegistro + "(" +
                    fecha_de_registro_id + " TEXT PRIMARY KEY," +
                    fecha_de_registro_nivel+ " TEXT," +
                    fecha_de_registro_cod_sede_reg + " TEXT," +
                    fecha_de_registro_cod_sede_prov+ " TEXT," +
                    fecha_de_registro_cod_sede_distrital+ " TEXT," +
                    fecha_de_registro_sede_region+ " TEXT," +
                    fecha_de_registro_sede_provincia+ " TEXT," +
                    fecha_de_registro_sede_distrital+ " TEXT," +
                    fecha_de_registro_cod_local + " TEXT," +
                    fecha_de_registro_nom_local + " TEXT," +
                    fecha_de_registro_direccion + " TEXT," +
                    fecha_de_registro_aula + " TEXT," +
                    fecha_de_registro_codigo + " TEXT," +
                    fecha_de_registro_nombres + " TEXT," +
                    fecha_de_registro_id_cargo+ " TEXT," +
                    fecha_de_registro_cargo+ " TEXT," +
                    fecha_de_registro_tipo_candidato+ " TEXT," +
                    fecha_de_registro_n_bungalow+ " TEXT," +
                    fecha_de_registro_resp_bungalow+ " TEXT," +
                    fecha_de_registro_fecha_registro1+ " TEXT," +
                    fecha_de_registro_fecha_registro2+ " TEXT," +
                    fecha_de_registro_dia1 + " TEXT," +
                    fecha_de_registro_mes1 + " TEXT," +
                    fecha_de_registro_anio1 + " TEXT," +
                    fecha_de_registro_hora1 + " TEXT," +
                    fecha_de_registro_minuto1 + " TEXT," +
                    fecha_de_registro_dia2 + " TEXT," +
                    fecha_de_registro_mes2 + " TEXT," +
                    fecha_de_registro_anio2 + " TEXT," +
                    fecha_de_registro_hora2 + " TEXT," +
                    fecha_de_registro_minuto2 + " TEXT," +
                    fecha_de_registro_estado1 + " TEXT," +
                    fecha_de_registro_estado2 + " TEXT," +
                    fecha_de_registro_subido1 + " INTEGER," +
                    fecha_de_registro_subido2 + " INTEGER"+");"
            ;

    public static final String SQL_CREATE_TABLA_FECHA_REGISTRO_TEMPORAL =
            "CREATE TABLE " + tablafecharegistrotemporal + "(" +
                    fecha_de_registro_id + " TEXT PRIMARY KEY," +
                    fecha_de_registro_nivel+ " TEXT," +
                    fecha_de_registro_cod_sede_reg + " TEXT," +
                    fecha_de_registro_cod_sede_prov+ " TEXT," +
                    fecha_de_registro_cod_sede_distrital+ " TEXT," +
                    fecha_de_registro_sede_region+ " TEXT," +
                    fecha_de_registro_sede_provincia+ " TEXT," +
                    fecha_de_registro_sede_distrital+ " TEXT," +
                    fecha_de_registro_cod_local + " TEXT," +
                    fecha_de_registro_nom_local + " TEXT," +
                    fecha_de_registro_direccion + " TEXT," +
                    fecha_de_registro_aula + " TEXT," +
                    fecha_de_registro_codigo + " TEXT," +
                    fecha_de_registro_nombres + " TEXT," +
                    fecha_de_registro_id_cargo+ " TEXT," +
                    fecha_de_registro_cargo+ " TEXT," +
                    fecha_de_registro_tipo_candidato+ " TEXT," +
                    fecha_de_registro_n_bungalow+ " TEXT," +
                    fecha_de_registro_resp_bungalow+ " TEXT," +
                    fecha_de_registro_fecha_registro1+ " TEXT," +
                    fecha_de_registro_fecha_registro2+ " TEXT," +
                    fecha_de_registro_dia1 + " TEXT," +
                    fecha_de_registro_mes1 + " TEXT," +
                    fecha_de_registro_anio1 + " TEXT," +
                    fecha_de_registro_hora1 + " TEXT," +
                    fecha_de_registro_minuto1 + " TEXT," +
                    fecha_de_registro_dia2 + " TEXT," +
                    fecha_de_registro_mes2 + " TEXT," +
                    fecha_de_registro_anio2 + " TEXT," +
                    fecha_de_registro_hora2 + " TEXT," +
                    fecha_de_registro_minuto2 + " TEXT," +
                    fecha_de_registro_estado1 + " TEXT," +
                    fecha_de_registro_estado2 + " TEXT," +
                    fecha_de_registro_subido1 + " INTEGER," +
                    fecha_de_registro_subido2 + " INTEGER"+");"
            ;


    public static final String WHERE_CLAUSE_CLAVE = "clave=?";
    public static final String WHERE_CLAUSE_CODIGO = "codigo=?";
    public static final String WHERE_CLAUSE_SEDE = "sede_region=?";
    public static final String WHERE_CLAUSE_COD_LOCAL = "cod_local=?";
    public static final String WHERE_CLAUSE_SUBIDO1 = "subido1=? and estado1=?";
    public static final String WHERE_CLAUSE_SUBIDO2 = "subido2=? and estado2=?";
    public static final String WHERE_CLAUSE_SUBIDO3 = "subido3=?";
    public static final String WHERE_CLAUSE_SUBIDO4 = "subido4=?";
    public static final String WHERE_CLAUSE_SEDESUBIDO1 = "cod_local=?  and subido1=?";
    public static final String WHERE_CLAUSE_AULA = "aula=?";


    public static final String[] COLUMNAS_NACIONAL = {
            nacional_nivel,nacional_cod_sede_reg,nacional_cod_sede_prov,
            nacional_cod_sede_distrital,nacional_sede_region,nacional_sede_provincia,nacional_sede_distrital,
            nacional_cod_local,nacional_nom_local,nacional_direccion,nacional_aula,nacional_codigo,nacional_nombres,
            nacional_id_cargo,nacional_cargo,nacional_tipo_candidato,nacional_n_bungalow,nacional_resp_bungalow
    };

    public static final String[] COLUMNAS_USUARIO_LOCAL = {
            usuario_local_id,
            usuario_local_usuario,
            usuario_local_clave,
            usuario_local_cod_local,
            usuario_local_nom_local,
            usuario_local_cod_sede_reg,
            usuario_local_sede_region,
            usuario_local_cod_nivel,
            usuario_local_nom_nivel,
            usuario_local_fase

    };

    public static final String[] COLUMNAS_FECHA_REGISTRO = {
            fecha_de_registro_id, fecha_de_registro_nivel,fecha_de_registro_cod_sede_reg,fecha_de_registro_cod_sede_prov,
            fecha_de_registro_cod_sede_distrital,fecha_de_registro_sede_region,fecha_de_registro_sede_provincia,fecha_de_registro_sede_distrital,
            fecha_de_registro_cod_local,fecha_de_registro_nom_local,fecha_de_registro_direccion,fecha_de_registro_aula,fecha_de_registro_codigo,fecha_de_registro_nombres,
            fecha_de_registro_id_cargo,fecha_de_registro_cargo,fecha_de_registro_tipo_candidato,fecha_de_registro_n_bungalow,fecha_de_registro_resp_bungalow,
            fecha_de_registro_fecha_registro1,fecha_de_registro_fecha_registro2,
            fecha_de_registro_dia1,fecha_de_registro_mes1,fecha_de_registro_anio1,fecha_de_registro_minuto1,fecha_de_registro_hora1,
            fecha_de_registro_dia2,fecha_de_registro_mes2,fecha_de_registro_anio2,fecha_de_registro_minuto2,fecha_de_registro_hora2,
            fecha_de_registro_estado1,fecha_de_registro_estado2,fecha_de_registro_subido1,fecha_de_registro_subido2
    };

    public static final String[] COLUMNAS_FECHA_REGISTRO_TEMPORAL = {
            fecha_de_registro_id, fecha_de_registro_nivel,fecha_de_registro_cod_sede_reg,fecha_de_registro_cod_sede_prov,
            fecha_de_registro_cod_sede_distrital,fecha_de_registro_sede_region,fecha_de_registro_sede_provincia,fecha_de_registro_sede_distrital,
            fecha_de_registro_cod_local,fecha_de_registro_nom_local,fecha_de_registro_direccion,fecha_de_registro_aula,fecha_de_registro_codigo,fecha_de_registro_nombres,
            fecha_de_registro_fecha_registro1,fecha_de_registro_fecha_registro2,
            fecha_de_registro_id_cargo,fecha_de_registro_cargo,fecha_de_registro_tipo_candidato,fecha_de_registro_n_bungalow,fecha_de_registro_resp_bungalow,
            fecha_de_registro_dia1,fecha_de_registro_mes1,fecha_de_registro_anio1,fecha_de_registro_minuto1,fecha_de_registro_hora1,
            fecha_de_registro_dia2,fecha_de_registro_mes2,fecha_de_registro_anio2,fecha_de_registro_minuto2,fecha_de_registro_hora2,
            fecha_de_registro_estado1,fecha_de_registro_estado2,fecha_de_registro_subido1,fecha_de_registro_subido2
    };

}
