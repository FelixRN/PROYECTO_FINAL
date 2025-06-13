# Configuración del Proyecto Java

Este proyecto fue desarrollado originalmente en NetBeans y puede ser ejecutado tanto en NetBeans como en Eclipse. Sigue las instrucciones correspondientes según tu IDE preferido.

## Requisitos Previos

<<<<<<< HEAD
- [**JDK 24**](https://jdk.java.net/24/) (última versión) 
=======
- [**JDK 24**](https://jdk.java.net/24/) (última versión)
>>>>>>> e9d454d74519e65603dbc62fb808c4b460a170f8
- **NetBeans** o **Eclipse IDE**
- Conexión a internet para descargar dependencias

## Dependencias del Proyecto

El proyecto utiliza las siguientes librerías:
<<<<<<< HEAD
- [`AbsoluteLayout.jar`](https://mvnrepository.com/artifact/org.netbeans.external/AbsoluteLayout/RELEASE260) - Para el diseño de interfaz
=======
- [`AbsoluteLayout.jar`](https://mvnrepository.com/artifact/org.netbeans.external/AbsoluteLayout/RELEASE802) - Para el diseño de interfaz
>>>>>>> e9d454d74519e65603dbc62fb808c4b460a170f8
- [`mysql-connector-j-9.3.0.jar`](https://mvnrepository.com/artifact/com.mysql/mysql-connector-j/9.3.0) - Conector MySQL para Java

## Configuración de Variables de Entorno

### Crear archivo .env

Crea un archivo llamado `.env` en la raíz del proyecto con el siguiente contenido:

```env
DB_HOST=
DB_PORT=
DB_USERNAME=
DB_PASSWORD=
DB_DATABASE=
```

## Configuración en Eclipse

### Paso 1: Importar el Proyecto
1. Abre Eclipse
2. Ve a `File` → `Import`
3. Selecciona `General` → `Existing Projects into Workspace`
4. Navega hasta la carpeta del proyecto
5. Haz clic en `Finish`

### Paso 2: Configurar JDK
1. Clic derecho en el proyecto → `Properties`
2. Ve a `Java Build Path` → `Libraries`
3. Expande `Modulepath` o `Classpath`
4. Selecciona la JRE actual → `Remove`
5. Haz clic en `Add Library` → `JRE System Library`
6. Selecciona `JDK 24`

### Paso 3: Añadir Librerías
1. En `Java Build Path` → `Libraries`
2. Haz clic en `Add External JARs`
3. Navega a la carpeta `libs` del proyecto
4. Selecciona y añade:
   - `AbsoluteLayout.jar`
   - `mysql-connector-j-9.3.0.jar`

### Paso 4: Configurar Variables de Entorno
1. Clic derecho en el proyecto → `Run As` → `Run Configurations`
2. Selecciona tu clase principal
3. Ve a la pestaña `Environment`
4. Añade las variables del archivo `.env`:
   - `DB_HOST`: 
   - `DB_PORT`: 
   - `DB_USERNAME`: 
   - `DB_PASSWORD`: 
   - `DB_DATABASE`: 

## Estructura del Proyecto

```
proyecto/
├── src/
│   └── [archivos fuente .java]
├── .env
└── README.md
```

## Solución de Problemas Comunes

### Error de Conexión a Base de Datos
- Verifica que las variables de entorno estén correctamente configuradas
- Asegúrate de tener conexión a internet
- Confirma que el archivo `.env` esté en la raíz del proyecto

### Errores de Compilación
- Verifica que JDK 24 esté correctamente configurado
- Asegúrate de que todas las librerías estén añadidas al classpath
- Revisa que no haya errores de sintaxis en el código

### Problemas con AbsoluteLayout
- Confirma que `AbsoluteLayout.jar` esté en el classpath
- Si usas Eclipse, puede que necesites limpiar y reconstruir el proyecto

## Ejecutar el Proyecto


### En Eclipse:
- Clic derecho en la clase principal → `Run As` → `Java Application`

## Notas Adicionales

- Este proyecto utiliza una base de datos MySQL alojada en Aiven Cloud
- Las credenciales de la base de datos están en el archivo `.env`
- Si necesitas modificar la configuración de la base de datos, edita el archivo `.env`
- Para desarrollo local, considera usar variables de entorno del sistema en lugar del archivo `.env`

## Soporte

Si encuentras problemas durante la configuración, verifica:
1. Versión de JDK instalada
2. Configuración del classpath
3. Conectividad a la base de datos
4. Permisos de archivos y carpetas