package cu.edu.uo.informatizacion.contraloria.BaseDatos

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import cu.edu.uo.informatizacion.contraloria.R


class DB_Manager(context: Context, name:String , factory:SQLiteDatabase.CursorFactory? , version:Int)
    : SQLiteOpenHelper(context,name,factory, version) {

    var crear_tabla_COMPONENTES = "CREATE TABLE COMPONENTES (nombre TEXT,concepto TEXT,normas TEXT,fuentes TEXT,sector INTEGER,imagen INTEGER,pdf TEXT)"
    var crear_tabla_ODS = "CREATE TABLE ODS (texto TEXT,indicadores TEXT,imagen INTEGER)"

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("DROP TABLE IF EXISTS 'COMPONENTES'")
        db!!.execSQL("DROP TABLE IF EXISTS 'ODS'")
        db!!.execSQL(crear_tabla_COMPONENTES)
        db!!.execSQL(crear_tabla_ODS)

        InsertarCOMPONENTES(db)
        InsertarODS(db)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS 'COMPONENTES'")
        db!!.execSQL("DROP TABLE IF EXISTS 'ODS'")
        db!!.execSQL(crear_tabla_COMPONENTES)
        db!!.execSQL(crear_tabla_ODS)

        InsertarCOMPONENTES(db)
        InsertarODS(db)
    }

    fun InsertarODS(database: SQLiteDatabase?) {

        var cv = ContentValues()
        cv.put("texto", "Poner fin a la pobreza en todas sus formas y en todo el mundo \n ")
        cv.put("imagen", R.mipmap.goals_1)
        cv.put("indicadores", "7 indicadores")

        database!!.insert("ODS",null,cv)

        cv.put("texto", "Poner fin al hambre, lograr la seguridad alimentaria y la mejora de la nutrición y promover\n" +
                "la agricultura sostenible ")
        cv.put("imagen", R.mipmap.goals_2)
        cv.put("indicadores", "8 indicadores")
        database!!.insert("ODS",null,cv)

        cv.put("texto", "Salud y Bienestar " +
                "")
        cv.put("imagen", R.mipmap.goals_3)
        cv.put("indicadores", "12 indicadores")
        database!!.insert("ODS",null,cv)

        cv.put("texto", "Garantizar una educación inclusiva y equitativa de calidad y promover oportunidades de aprendizaje permanente para todos ")
        cv.put("imagen", R.mipmap.goals_4)
        cv.put("indicadores", "10 indicadores")
        database!!.insert("ODS",null,cv)

        cv.put("texto", "Lograr la igualdad de género y empoderar a todas las mujeres y las niñas")
        cv.put("imagen", R.mipmap.goals_5)
        cv.put("indicadores", "9 indicadores")
        database!!.insert("ODS",null,cv)

        cv.put("texto", "Garantizar la disponibilidad y la gestión sostenible del agua y el saneamiento para todos  ")
        cv.put("imagen", R.mipmap.goals_6)
        cv.put("indicadores", "8 indicadores")
        database!!.insert("ODS",null,cv)

        cv.put("texto", "Garantizar el acceso a una energía asequible, fiable, sostenible y moderna para todos")
        cv.put("imagen", R.mipmap.goals_7)
        cv.put("indicadores", "5 indicadores")
        database!!.insert("ODS",null,cv)

        cv.put("texto", ". Promover el crecimiento económico sostenido, inclusivo y sostenible, el empleo pleno" +
                "y productivo y el trabajo decente para todos ")
        cv.put("imagen", R.mipmap.goals_8)
        cv.put("indicadores", "12 indicadores")
        database!!.insert("ODS",null,cv)

        cv.put("texto", "Construir infraestructuras resilientes, promover la industrialización inclusiva y sostenible" +
                "y fomentar la innovación")
        cv.put("imagen", R.mipmap.goals_9)
        cv.put("indicadores", "8 indicadores")
        database!!.insert("ODS",null,cv)

        cv.put("texto", "Reducir la desigualdad en los países y entre ellos ")
        cv.put("imagen", R.mipmap.goals_10)
        cv.put("indicadores", "10 indicadores")
        database!!.insert("ODS",null,cv)

        cv.put("texto", "Lograr que las ciudades y los asentamientos humanos sean inclusivos, seguros, resilientes" +
                "y sostenibles ")
        cv.put("imagen", R.mipmap.goals_11)
        cv.put("indicadores", "10 indicadores")
        database!!.insert("ODS",null,cv)

        cv.put("texto", "Garantizar modalidades de consumo y producción sostenibles")
        cv.put("imagen", R.mipmap.goals_12)
        cv.put("indicadores", "11 indicadores")
        database!!.insert("ODS",null,cv)

        cv.put("texto", "Adoptar medidas urgentes para combatir el cambio climático y sus efectos")
        cv.put("imagen", R.mipmap.goals_13)
        cv.put("indicadores", "5 indicadores")
        database!!.insert("ODS",null,cv)

        cv.put("texto", "Conservar y utilizar sosteniblemente los océanos, los mares y los recursos marinos" +
                "para el desarrollo sostenible")
        cv.put("imagen", R.mipmap.goals_14)
        cv.put("indicadores", "10 indicadores")
        database!!.insert("ODS",null,cv)

        cv.put("texto", ". Proteger, restablecer y promover el uso sostenible de los ecosistemas terrestres, gestionar" +
                "sosteniblemente los bosques, luchar contra la desertificación, detener e invertir la degradación de las" +
                "tierras y detener la pérdida de biodiversidad ")
        cv.put("imagen", R.mipmap.goals_15)
        cv.put("indicadores", "12 indicadores")
        database!!.insert("ODS",null,cv)

        cv.put("texto", "Promover sociedades pacíficas e inclusivas para el desarrollo sostenible, facilitar el acceso a la" +
                "justicia para todos y construir a todos los niveles instituciones eficaces e inclusivas que rindan cuentas")
        cv.put("imagen", R.mipmap.goals_16)
        cv.put("indicadores", "12 indicadores")
        database!!.insert("ODS",null,cv)

        cv.put("texto", "Fortalecer los medios de implementación y revitalizar la Alianza Mundial" +
                "para el Desarrollo Sostenible " )
        cv.put("imagen", R.mipmap.goals_17)
        cv.put("indicadores", "• Finanzas: 5 indicadores. \n" +
                "• Tecnologia.: 3 indicadores \n" +
                "• Creacion de capacidad : 1 indicador  \n" +
                "• Comercio: 3 indicadores. \n" +
                "• Cuestiones sistémicas: 3 indicadores. \n" +
                "• Alianzas entre múltiples interesados: 2 indicadores \n" +
                "• Datos, vigilancia y rendición de cuentas: 2 indicadores")
        database!!.insert("ODS",null,cv)


    }

    fun InsertarCOMPONENTES(database: SQLiteDatabase?)
    {

        var cv = ContentValues()
        cv.put("nombre","Ambiente de control")
        cv.put("concepto","Art 10\n Sienta las pautas para el funcionamiento legal y armónico de los órganos, organismos, organizaciones y demás entidades, para el desarrollo de las acciones, reflejando la actitud asumida por la máxima dirección y el resto del colectivo en relación con la importancia del Sistema de Control Interno. Este puede considerarse como la base de los demás componentes. Conforma un conjunto de buenas prácticas y documentos referidos a la constitución de la organización, al marco legal de las operaciones aprobadas, a la creación de los órganos de dirección y consultivos, a los procesos, sistemas y políticas, disposiciones legales y procedimientos, lo que tiene que ser dominio de todos los implicados y estar a su alcance.")
        cv.put("normas","Planeación, planes de trabajo anual, mensual e individual\n" +
                "Integridad y valores éticos\n" +
                "Idoneidad demostrada\n" +
                "Estructura organizativa y asignación de autoridad y responsabilidad\n" +
                "Políticas y prácticas en la gestión de recursos humanos.\n")
        cv.put("fuentes","Principales fuentes de información para el autocontrol\n" +
                "\n" +
                "•\tResolución de constitución de la entidad y función estatal.\n" +
                "•\tResoluciones de constitución de los órganos de dirección y consultivos.\n" +
                "•\tEstructura y diagrama organizacional.\n" +
                "•\tManual de Procedimientos para las actividades que procedan, Manual de Funcionamiento o Reglamento Orgánico.\n" +
                "•\tManual de Contabilidad General.\n" +
                "•\tClasificador por objeto del gasto del presupuesto.\n" +
                "•\tSistema de normas de gastos para la actividad que realizan.\n" +
                "•\tReglamento Disciplinario Interno, Código de Conducta y/o Ética.\n" +
                "•\tReglamento para la estimulación moral de los trabajadores.\n" +
                "•\tReglamento para otros pagos, en los casos que corresponda.\n" +
                "•\tReglamento de información interna y externa.\n" +
                "•\tDiseño de los cuadros de mando de la información de cada jefe de la entidad.\n" +
                "•\tPlan de las demandas de tiempo de paz para los órganos de la defensa, la reserva estatal, reserva movilizativa y la defensa civil.\n" +
                "•\tPlanes de la demanda en situaciones excepcionales y las conciliaciones con los órganos de la defensa.\n" +
                "•\tPlanes contra desastres y su compatibilización con los órganos de la defensa civil.\n" +
                "•\tObjetivos de Trabajo y Plan Anual de Actividades.\n" +
                "•\tPlanes de trabajo, anual, mensual e individual de las áreas, según la estructura organizacional.\n" +
                "•\tActas del Consejo de Dirección.\n" +
                "•\tActas de las asambleas de afiliados con los trabajadores. \n" +
                "•\tControl de contratos.\n" +
                "•\tControl de obligaciones con proveedores y prestamistas.\n" +
                "•\tControl del parque de vehículo\n" +
                "•\t Normas Cubanas del Sistema de Gestión Integrada de Capital Humano que aplican\n" +
                "•\tPlantilla aprobada y cubierta.\n" +
                "•\tFunciones generales y específicas de cada uno de los cargos.\n" +
                "•\tConvenio Colectivo de Trabajo.\n" +
                "•\tExpedientes laborales habilitados por trabajador.\n" +
                "•\tDiseño de los puestos de trabajo acorde con la legislación laboral vigente.\n" +
                "•\tFormas y sistemas de pago aprobados.\n" +
                "•\tPolítica sobre la selección y capacitación del personal.\n" +
                "•\tPlan de Capacitación y Desarrollo.\n" +
                "•\tProyección estratégica. Objetivos de trabajo.\n" +
                "•\tNotificación Presupuestaria.\n" +
                "•\tModificaciones Presupuestarias.\n" +
                "•\tEstados financieros e indicadores de economía, eficiencia y eficacia fundamentales.\n" +
                "•\tProgramación de Pagos\n" +
                "•\tFlujo de Efectivo o Caja\n" +
                "•\tPlan de la economía y presupuesto aprobado.\n" +
                "•\tProgramación y Desagregación del Presupuesto aprobado.\n" +
                "•\tExpediente de las acciones de control.\n" +
                "•\tExpediente de los inmuebles.\n" +
                "•\tRegistro de quejas y denuncias.\n" +
                "•\tPlan de Auditoría Interna aprobado por el nivel correspondiente.\n" +
                "•\tSitio donde se encuentra disponible la legislación vigente, particularmente aquella aplicable en su ámbito de competencia.\n" +
                "•\tLa disposición que aprueba las funciones que puede realizar el director.\n" +
                "•\tLas licencias otorgadas por los organismos rectores.\n" +
                "•\tPlan de prevención y riesgos actualizado.\n")
        cv.put("sector",0)
        cv.put("imagen",R.mipmap.emp_ac)
        cv.put("pdf","AMB_CONTROL_GAC_AEmpresarial_2019.pdf")
        database!!.insert("COMPONENTES",null,cv)

        cv.put("nombre","Gestión y prevención de riesgo")
        cv.put("concepto","Articulo 11\n" +
                "Establece las bases para la identificación y análisis de los riesgos, que enfrentan los órganos, organismos, organizaciones y demás entidades para alcanzar sus objetivos. Una vez clasificados los riesgos en internos y externos, por proceso, actividades y operaciones y evaluadas las principales vulnerabilidades, se determinan los objetivos de control y se conforma el Plan de Prevención de Riesgos, para definir el modo en que habrán de gestionarse. Existen riesgos que están regulados por disposiciones legales de los organismos rectores, los que se gestionan según modelos de administración previstos\n")
        cv.put("normas","Identificación de riesgos y detección de cambio\n" +
                "Determinación de los objetivos de control\n" +
                "Prevención de riesgos\n")
        cv.put("fuentes","Principales fuentes de información para el autocontrol\n" +
                "•\tHechos extraordinarios ocurridos relacionados con fraudes (financieros, contables, informáticos), incumplimientos de los clientes, proveedores u otros acreedores, violaciones de las normas de seguridad y protección físicas que ocasionaron robos y perdidas a la entidad, etc.\n" +
                "•\tDocumentos que refieren cambios en el contexto externo e interno: legislación, reglamentos, programas de ajuste, tecnología, modificaciones estructurales, de misión, de autoridades, etc.\n" +
                "•\tNuevas líneas de productos o servicios: la inversión en la producción de nuevos bienes y servicios generalmente ocasionan desajustes en el Sistema de Control Interno, el que debe ser revisado.\n" +
                "•\tReorganizaciones generalmente significan reducciones de personal que ocasionan, si no racionalmente practicadas, alteraciones en la separación de funciones y en el nivel de supervisión.\n" +
                "•\tPlan de Prevención de Riesgos vigente actualizado y muestra de los periodos precedentes.\n" +
                "•\tTécnicas aplicadas que permitan constatar y evaluar los conocimientos de los directivos y trabajadores sobre la cultura de gestión y prevención de riesgos de la entidad.\n")
        cv.put("sector",0)
        cv.put("imagen",R.mipmap.emp_gypr)
        cv.put("pdf","GEST_PREV_RIESGOS_GAC_AEmpresarial_2019.pdf")
        database!!.insert("COMPONENTES",null,cv)


        cv.put("nombre","Actividades de control")
        cv.put("concepto","Artículo 12:" +
                "\n" +
                "Establece las políticas, disposiciones legales y procedimientos de control necesarios para gestionar y verificar la calidad de la gestión, su seguridad razonable con los requerimientos institucionales, para el cumplimiento de los objetivos y misión de los órganos, organismos, organizaciones y demás entidades. Las actividades de control son aplicables a las operaciones de todo tipo, las que tributan a la fiabilidad de la información financiera y al cumplimiento de las disposiciones legales correspondientes al marco de desarrollo de la actividad, así como la comprobación de transacciones u operaciones económicas que le dan cobertura a los objetivos y metas en cuanto a su exactitud, autorización y registro contable conforme a las normas cubanas establecidas al efecto, con un enfoque de mejoramiento continuo\n")
        cv.put("normas","Coordinación entre áreas, separación de tareas, responsabilidades y niveles de autorización.\n" +
                "Documentación, registro oportuno y adecuado de las transacciones y hechos.\n" +
                "Acceso restringido a los recursos, activos y registros\n" +
                "Rotación del personal en tareas calves\n" +
                "Control de las tecnologías de la información y las comunicaciones\n" +
                "Indicadores de rendimiento y de desempeño\n")
        cv.put("fuentes","Principales fuentes de información para el autocontrol\n" +
                "•\tManual de Procedimientos y de Organización.\n" +
                "•\tManual de Contabilidad General.\n" +
                "•\tClasificador por objeto del gasto del presupuesto.\n" +
                "•\tPlan de Prevención de Riesgos actualizado.\n" +
                "•\tDocumentación donde se definan los procesos y las operaciones por actividades. \n" +
                "•\tPlan de la economía y presupuesto aprobado; estados financieros e indicadores de economía, eficiencia y eficacia fundamentales.\n" +
                "•\tSistema de normas de gastos para la actividad que realizan.\n" +
                "•\tFunciones generales y específicas de los cargos.\n" +
                "\n" +
                "Se deberá comprobar que los manuales habilitados en la entidad contengan los procedimientos  del Manual de Normas de Control Interno, aprobado por la Ministra de Finanzas y Precios; los procedimientos de Contabilidad General y Contabilidad de Costos, debiendo en cada caso estar elaborados y aprobados por el nivel correspondiente.\n" +
                "\n" +
                "En el caso del Manual de Procedimientos y de Organización se deberá constatar que contenga entre otros los aspectos referidos a:\n" +
                "•\tSeparación de tareas y responsabilidades, o en su defecto la forma de supervisión o monitoreo.\n" +
                "•\tCoordinación entre áreas.\n" +
                "•\tDocumentación.\n" +
                "•\tNiveles definidos de dirección.\n" +
                "•\tRegistro oportuno y adecuado de las transacciones y hechos.\n" +
                "•\tAcceso restringido a los recursos, activos y registros.\n" +
                "•\tRotación de personal en las tareas claves.\n" +
                "•\tControl del sistema de información.\n" +
                "•\tIndicadores de desempeño.\n" +
                "•\tFunción de Auditoría Interna, acorde a las normas vigentes.\n" +
                "•\tEntrega recepción de los cargos\n" +
                "\n" +
                " Examinar que el Manual de Contabilidad General incluya:\n" +
                "\n" +
                "•\tOrganización del registro contable, subdivisiones para el registro de la información primaria (área, departamento, divisiones, entre otros).\n" +
                "•\tPrincipales características de explotación si utiliza sistema contable soportado sobre tecnologías de la información.\n" +
                "•\tDetalle del sistema utilizado para el procesamiento del registro contable y de la emisión de las informaciones derivadas de este.\n" +
                "•\tNomenclador de cuentas, que precise las cuentas, subcuentas y análisis, tanto de uso general como específico, que deben utilizarse en la entidad, de acuerdo con las actividades que desarrolla y el modo de procesamiento de la información.\n" +
                "•\tDefinición del contenido y uso de las cuentas, subcuentas y análisis.\n" +
                "•\tDiseño de los estados financieros de la entidad.\n" +
                "•\tProcedimientos contables a aplicar, basados en las regulaciones emitidas por los organismos globales y ramales, los específicos de cada entidad, atendiendo a las particularidades de su actividad y a los requisitos de su organización y dirección. Estos procedimientos pueden contener ejemplos ilustrativos del registro contable del hecho económico.\n" +
                "•\tDiseño del conjunto de modelos y documentos que se necesitan utilizar en la entidad, respetando en los casos que proceda la información de uso obligatorio establecida por la legislación vigente.\n" +
                "\n" +
                "En todos los casos se deberá verificar que se defina:\n" +
                "\n" +
                "•\tÁrea de elaboración de los modelos.\n" +
                "•\tEn los casos que proceda el destino de las copias.\n" +
                "•\tTiempo de conservación en correspondencia con la legislación vigente.\n" +
                "•\tLugar de conservación de cada documento.\n")
        cv.put("sector",0)
        cv.put("imagen",R.mipmap.emp_ac)
        cv.put("pdf","ACTIVIDADES_DE_CONTROL_GAC_AEmpresarial_2019.pdf")
        database!!.insert("COMPONENTES",null,cv)


        cv.put("nombre","Información y comunicaciones")
        cv.put("concepto","Articulo 13\n" +
                "Precisa que los órganos y organismos, organizaciones y demás entidades deben de disponer de información oportuna, fiable y definir su sistema de información adecuado a sus características, que generan datos, documentos y reportes que sustentan los resultados de las actividades operativas, financieras y relacionadas con el cumplimiento de los objetivos, metas y estrategias, con mecanismos de retroalimentación y la rendición transparente de cuentas. La información debe protegerse y conservarse según las disposiciones vigentes.\n")
        cv.put("normas","Sistema de información, flujo y canales de comunicación\n" +
                "Contenido, calidad y responsabilidad\n" +
                "Rendición de cuentas\n")
        cv.put("fuentes","Principales fuentes de información para el autocontrol\n" +
                "•\tReglamento de información interna y externa.\n" +
                "•\tDiseño de los cuadros de mando de la información de cada jefe de la entidad.\n" +
                "•\tSistema de informatización y automatización de cada jefe de la entidad.\n" +
                "•\tSistema de informatización y automatización de la gestión\n" +
                "•\tManual de identidad corporativa.,\n" +
                "•\tSistemas de información estadísticas.\n" +
                "•\tSistemas de información contable.\n" +
                "•\tSistema de información de gobierno.\n" +
                "•\tManual de Gestión de comunicación\n" +
                "•\tEstrategia de comunicación\n" +
                "•\tFlujos de comunicación\n" +
                "•\tReportes de los softwares utilizados en la entidad.\n" +
                "•\tManuales de usuarios del software.\n" +
                "•\tIntranet.\n" +
                "•\tWeb.\n")
        cv.put("sector",0)
        cv.put("imagen",R.mipmap.emp_iyc)
        cv.put("pdf","INFORM_Y_COMUNIC_GAC_AEmpresarial_2019.pdf")
        database!!.insert("COMPONENTES",null,cv)


        cv.put("nombre","Supervisión y monitoreo")
        cv.put("concepto","Articulo 14\n" +
                " Está dirigido a la detección de errores e irregularidades que no fueron detectadas con las actividades de control, permitiendo realizar las correcciones y modificaciones necesarias. Esta se realiza mediante las modalidades de supervisión, actividades continuas que son aquellas que incorporadas a las actividades normales generan respuestas dinámicas, entre ellas el seguimiento dinámico realizado por las diferentes estructuras de dirección y evaluaciones puntuales que son ejecutadas por los responsables de las áreas, por auditorías internas y externas")
        cv.put("normas","Evaluación y determinación de la eficacia del Sistema de Control Interno.\n" +
                "Comité de prevención y control\n")
        cv.put("fuentes","Principales fuentes de información para el autocontrol\n" +
                "•\tActas del Comité de Prevención y Control\n" +
                "•\tPlan de auditoría Interna.\n" +
                "•\tPlan de prevención de Riesgos actualizado.\n" +
                "•\tExpedientes de acciones de control\n" +
                "•\tPlan de Trabajo mensual (específicamente lo referido a las medidas de autocontrol que corresponden verificar según Plan de Prevención).\n" +
                "•\tEvidencia documental del análisis con los trabajadores de las autoevaluaciones del Sistema de Control Interno.\n" +
                "•\tGuía de Autocontrol adecuada y actualizada.\n")
        cv.put("sector",0)
        cv.put("imagen",R.mipmap.emp_sym)
        cv.put("pdf","SUPERV_Y_MONITOREO_GAC_AEmpresarial_2019.pdf")
        database!!.insert("COMPONENTES",null,cv)

        cv.put("nombre","Ambiente de control")
        cv.put("concepto","Art 10 \nSienta las pautas para el funcionamiento legal y armónico de los órganos, organismos, organizaciones y demás entidades, para el desarrollo de las acciones, reflejando la actitud asumida por la máxima dirección y el resto del colectivo en relación con la importancia del Sistema de Control Interno. Este puede considerarse como la base de los demás componentes. Conforma un conjunto de buenas prácticas y documentos referidos a la constitución de la organización, al marco legal de las operaciones aprobadas, a la creación de los órganos de dirección y consultivos, a los procesos, sistemas y políticas, disposiciones legales y procedimientos, lo que tiene que ser dominio de todos los implicados y estar a su alcance.")
        cv.put("normas","Planeación, planes de trabajo anual, mensual e individual\n" +
                "Integridad y valores éticos\n" +
                "Idoneidad demostrada\n" +
                "Estructura organizativa y asignación de autoridad y responsabilidad\n" +
                "Políticas y prácticas en la gestión de recursos humanos.\n")
        cv.put("fuentes","Principales fuentes de información para el autocontrol\n" +
                "\n" +
                "•\tResolución de constitución de la entidad y función estatal.\n" +
                "•\tResoluciones de constitución de los órganos de dirección y consultivos.\n" +
                "•\tEstructura y diagrama organizacional.\n" +
                "•\tManual de Procedimientos para las actividades que procedan, Manual de Funcionamiento o Reglamento Orgánico.\n" +
                "•\tManual de Contabilidad General.\n" +
                "•\tClasificador por objeto del gasto del presupuesto.\n" +
                "•\tSistema de normas de gastos para la actividad que realizan.\n" +
                "•\tReglamento Disciplinario Interno, Código de Conducta y/o Ética.\n" +
                "•\tReglamento para la estimulación moral de los trabajadores.\n" +
                "•\tReglamento para otros pagos, en los casos que corresponda.\n" +
                "•\tReglamento de información interna y externa.\n" +
                "•\tDiseño de los cuadros de mando de la información de cada jefe de la entidad.\n" +
                "•\tPlan de las demandas de tiempo de paz para los órganos de la defensa, la reserva estatal, reserva movilizativa y la defensa civil.\n" +
                "•\tPlanes de la demanda en situaciones excepcionales y las conciliaciones con los órganos de la defensa.\n" +
                "•\tPlanes contra desastres y su compatibilización con los órganos de la defensa civil.\n" +
                "•\tObjetivos de Trabajo y Plan Anual de Actividades.\n" +
                "•\tPlanes de trabajo, anual, mensual e individual de las áreas, según la estructura organizacional.\n" +
                "•\tActas del Consejo de Dirección.\n" +
                "•\tActas de las asambleas de afiliados con los trabajadores. \n" +
                "•\tControl de contratos.\n" +
                "•\tControl de obligaciones con proveedores y prestamistas.\n" +
                "•\tControl del parque de vehículo\n" +
                "•\t Normas Cubanas del Sistema de Gestión Integrada de Capital Humano que aplican\n" +
                "•\tPlantilla aprobada y cubierta.\n" +
                "•\tFunciones generales y específicas de cada uno de los cargos.\n" +
                "•\tConvenio Colectivo de Trabajo.\n" +
                "•\tExpedientes laborales habilitados por trabajador.\n" +
                "•\tDiseño de los puestos de trabajo acorde con la legislación laboral vigente.\n" +
                "•\tFormas y sistemas de pago aprobados.\n" +
                "•\tPolítica sobre la selección y capacitación del personal.\n" +
                "•\tPlan de Capacitación y Desarrollo.\n" +
                "•\tProyección estratégica. Objetivos de trabajo.\n" +
                "•\tNotificación Presupuestaria.\n" +
                "•\tModificaciones Presupuestarias.\n" +
                "•\tEstados financieros e indicadores de economía, eficiencia y eficacia fundamentales.\n" +
                "•\tProgramación de Pagos\n" +
                "•\tFlujo de Efectivo o Caja\n" +
                "•\tPlan de la economía y presupuesto aprobado.\n" +
                "•\tProgramación y Desagregación del Presupuesto aprobado.\n" +
                "•\tExpediente de las acciones de control.\n" +
                "•\tExpediente de los inmuebles.\n" +
                "•\tRegistro de quejas y denuncias.\n" +
                "•\tPlan de Auditoría Interna aprobado por el nivel correspondiente.\n" +
                "•\tSitio donde se encuentra disponible la legislación vigente, particularmente aquella aplicable en su ámbito de competencia.\n" +
                "•\tLa disposición que aprueba las funciones que puede realizar el director.\n" +
                "•\tLas licencias otorgadas por los organismos rectores.\n" +
                "•\tPlan de prevención y riesgos actualizado.\n")
        cv.put("sector",1)
        cv.put("imagen",R.mipmap.pre_ac)
        cv.put("pdf","AMBIENTE_CONTROL_GAC_APresupuestada2019.pdf")
        database!!.insert("COMPONENTES",null,cv)

        cv.put("nombre","Gestión y prevención de riesgo")
        cv.put("concepto","Articulo 11\n" +
                "Establece las bases para la identificación y análisis de los riesgos, que enfrentan los órganos, organismos, organizaciones y demás entidades para alcanzar sus objetivos. Una vez clasificados los riesgos en internos y externos, por proceso, actividades y operaciones y evaluadas las principales vulnerabilidades, se determinan los objetivos de control y se conforma el Plan de Prevención de Riesgos, para definir el modo en que habrán de gestionarse. Existen riesgos que están regulados por disposiciones legales de los organismos rectores, los que se gestionan según modelos de administración previstos\n")
        cv.put("normas","Identificación de riesgos y detección de cambio\n" +
                "Determinación de los objetivos de control\n" +
                "Prevención de riesgos\n")
        cv.put("fuentes","Principales fuentes de información para el autocontrol\n" +
                "•\tHechos extraordinarios ocurridos relacionados con fraudes (financieros, contables, informáticos), incumplimientos de los clientes, proveedores u otros acreedores, violaciones de las normas de seguridad y protección físicas que ocasionaron robos y perdidas a la entidad, etc.\n" +
                "•\tDocumentos que refieren cambios en el contexto externo e interno: legislación, reglamentos, programas de ajuste, tecnología, modificaciones estructurales, de misión, de autoridades, etc.\n" +
                "•\tNuevas líneas de productos o servicios: la inversión en la producción de nuevos bienes y servicios generalmente ocasionan desajustes en el Sistema de Control Interno, el que debe ser revisado.\n" +
                "•\tReorganizaciones generalmente significan reducciones de personal que ocasionan, si no racionalmente practicadas, alteraciones en la separación de funciones y en el nivel de supervisión.\n" +
                "•\tPlan de Prevención de Riesgos vigente actualizado y muestra de los periodos precedentes.\n" +
                "•\tTécnicas aplicadas que permitan constatar y evaluar los conocimientos de los directivos y trabajadores sobre la cultura de gestión y prevención de riesgos de la entidad.\n")
        cv.put("sector",1)
        cv.put("imagen",R.mipmap.pre_gypr)
        cv.put("pdf","GEST_Y_PREV_RIESGOS_GAC_APresupuestada_2019.pdf")
        database!!.insert("COMPONENTES",null,cv)


        cv.put("nombre","Actividades de control")
        cv.put("concepto","Artículo 12:" +
                "\n" +
                "Establece las políticas, disposiciones legales y procedimientos de control necesarios para gestionar y verificar la calidad de la gestión, su seguridad razonable con los requerimientos institucionales, para el cumplimiento de los objetivos y misión de los órganos, organismos, organizaciones y demás entidades. Las actividades de control son aplicables a las operaciones de todo tipo, las que tributan a la fiabilidad de la información financiera y al cumplimiento de las disposiciones legales correspondientes al marco de desarrollo de la actividad, así como la comprobación de transacciones u operaciones económicas que le dan cobertura a los objetivos y metas en cuanto a su exactitud, autorización y registro contable conforme a las normas cubanas establecidas al efecto, con un enfoque de mejoramiento continuo\n")
        cv.put("normas","Coordinación entre áreas, separación de tareas, responsabilidades y niveles de autorización.\n" +
                "Documentación, registro oportuno y adecuado de las transacciones y hechos.\n" +
                "Acceso restringido a los recursos, activos y registros\n" +
                "Rotación del personal en tareas calves\n" +
                "Control de las tecnologías de la información y las comunicaciones\n" +
                "Indicadores de rendimiento y de desempeño\n")
        cv.put("fuentes","Principales fuentes de información para el autocontrol\n" +
                "•\tManual de Procedimientos y de Organización.\n" +
                "•\tManual de Contabilidad General.\n" +
                "•\tClasificador por objeto del gasto del presupuesto.\n" +
                "•\tPlan de Prevención de Riesgos actualizado.\n" +
                "•\tDocumentación donde se definan los procesos y las operaciones por actividades. \n" +
                "•\tPlan de la economía y presupuesto aprobado; estados financieros e indicadores de economía, eficiencia y eficacia fundamentales.\n" +
                "•\tSistema de normas de gastos para la actividad que realizan.\n" +
                "•\tFunciones generales y específicas de los cargos.\n" +
                "\n" +
                "Se deberá comprobar que los manuales habilitados en la entidad contengan los procedimientos  del Manual de Normas de Control Interno, aprobado por la Ministra de Finanzas y Precios; los procedimientos de Contabilidad General y Contabilidad de Costos, debiendo en cada caso estar elaborados y aprobados por el nivel correspondiente.\n" +
                "\n" +
                "En el caso del Manual de Procedimientos y de Organización se deberá constatar que contenga entre otros los aspectos referidos a:\n" +
                "•\tSeparación de tareas y responsabilidades, o en su defecto la forma de supervisión o monitoreo.\n" +
                "•\tCoordinación entre áreas.\n" +
                "•\tDocumentación.\n" +
                "•\tNiveles definidos de dirección.\n" +
                "•\tRegistro oportuno y adecuado de las transacciones y hechos.\n" +
                "•\tAcceso restringido a los recursos, activos y registros.\n" +
                "•\tRotación de personal en las tareas claves.\n" +
                "•\tControl del sistema de información.\n" +
                "•\tIndicadores de desempeño.\n" +
                "•\tFunción de Auditoría Interna, acorde a las normas vigentes.\n" +
                "•\tEntrega recepción de los cargos\n" +
                "\n" +
                " Examinar que el Manual de Contabilidad General incluya:\n" +
                "\n" +
                "•\tOrganización del registro contable, subdivisiones para el registro de la información primaria (área, departamento, divisiones, entre otros).\n" +
                "•\tPrincipales características de explotación si utiliza sistema contable soportado sobre tecnologías de la información.\n" +
                "•\tDetalle del sistema utilizado para el procesamiento del registro contable y de la emisión de las informaciones derivadas de este.\n" +
                "•\tNomenclador de cuentas, que precise las cuentas, subcuentas y análisis, tanto de uso general como específico, que deben utilizarse en la entidad, de acuerdo con las actividades que desarrolla y el modo de procesamiento de la información.\n" +
                "•\tDefinición del contenido y uso de las cuentas, subcuentas y análisis.\n" +
                "•\tDiseño de los estados financieros de la entidad.\n" +
                "•\tProcedimientos contables a aplicar, basados en las regulaciones emitidas por los organismos globales y ramales, los específicos de cada entidad, atendiendo a las particularidades de su actividad y a los requisitos de su organización y dirección. Estos procedimientos pueden contener ejemplos ilustrativos del registro contable del hecho económico.\n" +
                "•\tDiseño del conjunto de modelos y documentos que se necesitan utilizar en la entidad, respetando en los casos que proceda la información de uso obligatorio establecida por la legislación vigente.\n" +
                "\n" +
                "En todos los casos se deberá verificar que se defina:\n" +
                "\n" +
                "•\tÁrea de elaboración de los modelos.\n" +
                "•\tEn los casos que proceda el destino de las copias.\n" +
                "•\tTiempo de conservación en correspondencia con la legislación vigente.\n" +
                "•\tLugar de conservación de cada documento.\n")
        cv.put("sector",1)
        cv.put("imagen",R.mipmap.pre_adc)
        cv.put("pdf","ACTIVIDAD_DE_CONTROL_GAC_APresupuestada2019.pdf")
        database!!.insert("COMPONENTES",null,cv)


        cv.put("nombre","Información y comunicaciones")
        cv.put("concepto","Articulo 13\n" +
                "Precisa que los órganos y organismos, organizaciones y demás entidades deben de disponer de información oportuna, fiable y definir su sistema de información adecuado a sus características, que generan datos, documentos y reportes que sustentan los resultados de las actividades operativas, financieras y relacionadas con el cumplimiento de los objetivos, metas y estrategias, con mecanismos de retroalimentación y la rendición transparente de cuentas. La información debe protegerse y conservarse según las disposiciones vigentes.\n")
        cv.put("normas","Sistema de información, flujo y canales de comunicación\n" +
                "Contenido, calidad y responsabilidad\n" +
                "Rendición de cuentas\n")
        cv.put("fuentes","Principales fuentes de información para el autocontrol\n" +
                "•\tReglamento de información interna y externa.\n" +
                "•\tDiseño de los cuadros de mando de la información de cada jefe de la entidad.\n" +
                "•\tSistema de informatización y automatización de cada jefe de la entidad.\n" +
                "•\tSistema de informatización y automatización de la gestión\n" +
                "•\tManual de identidad corporativa.,\n" +
                "•\tSistemas de información estadísticas.\n" +
                "•\tSistemas de información contable.\n" +
                "•\tSistema de información de gobierno.\n" +
                "•\tManual de Gestión de comunicación\n" +
                "•\tEstrategia de comunicación\n" +
                "•\tFlujos de comunicación\n" +
                "•\tReportes de los softwares utilizados en la entidad.\n" +
                "•\tManuales de usuarios del software.\n" +
                "•\tIntranet.\n" +
                "•\tWeb.\n")
        cv.put("sector",1)
        cv.put("imagen",R.mipmap.pre_iyc)
        cv.put("pdf","INFORM_Y_COMUNIC_GAC_APresupuestada_2019.pdf")
        database!!.insert("COMPONENTES",null,cv)


        cv.put("nombre","Supervisión y monitoreo")
        cv.put("concepto","Articulo 14\n" +
                " Está dirigido a la detección de errores e irregularidades que no fueron detectadas con las actividades de control, permitiendo realizar las correcciones y modificaciones necesarias. Esta se realiza mediante las modalidades de supervisión, actividades continuas que son aquellas que incorporadas a las actividades normales generan respuestas dinámicas, entre ellas el seguimiento dinámico realizado por las diferentes estructuras de dirección y evaluaciones puntuales que son ejecutadas por los responsables de las áreas, por auditorías internas y externas")
        cv.put("normas","Evaluación y determinación de la eficacia del Sistema de Control Interno.\n" +
                "Comité de prevención y control\n")
        cv.put("fuentes","Principales fuentes de información para el autocontrol\n" +
                "•\tActas del Comité de Prevención y Control\n" +
                "•\tPlan de auditoría Interna.\n" +
                "•\tPlan de prevención de Riesgos actualizado.\n" +
                "•\tExpedientes de acciones de control\n" +
                "•\tPlan de Trabajo mensual (específicamente lo referido a las medidas de autocontrol que corresponden verificar según Plan de Prevención).\n" +
                "•\tEvidencia documental del análisis con los trabajadores de las autoevaluaciones del Sistema de Control Interno.\n" +
                "•\tGuía de Autocontrol adecuada y actualizada.\n" )
                 cv.put("sector",1)
        cv.put("imagen",R.mipmap.pre_sym)
        cv.put("pdf","SUPERV_Y_MONITORE_GAC_APresupuestada_2019.pdf")
        database!!.insert("COMPONENTES",null,cv)
        //Ready()
    }

   /* private fun Ready()
    {
        var cv = ContentValues()
        cv.put("ready",1)
        database.update("READY",cv,"WHERE ready==0",null)
        close()
    }

    fun isReady():Boolean
    {
        return database.isDbLockedByCurrentThread
       /* var cursor = database.rawQuery("SELECT * FROM READY", null)
        var re = 0;
        if (cursor.moveToFirst()) {
            re = cursor.getInt(0)
        }
        return re==0;*/
    }*/
}