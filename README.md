
# StormPlugin

StormPlugin es un plugin para Minecraft que gestiona las tormentas en el servidor. Incluye el control del tiempo de tormenta, la activación y desactivación de tormentas, y la sincronización de datos con una base de datos MySQL.

## Características

- Controlar el tiempo de la tormenta.
- Activar y desactivar tormentas.
- Sincronización de datos en tiempo real con una base de datos MySQL.
- Manejo de eventos relacionados con las tormentas (muerte de jugadores, intentos de dormir durante tormentas, etc.).

## Comandos

| Comando                           | Descripción                                                                                       |
|-----------------------------------|---------------------------------------------------------------------------------------------------|
| `/storm reset`                    | Restablece el tiempo de la tormenta a 0 y despeja el clima.                                       |
| `/storm set BaseTime <tiempo>`    | Establece el tiempo base de la tormenta en segundos.                                              |
| `/storm set CurrentTime <tiempo>` | Establece el tiempo actual de la tormenta en segundos.                                            |
| `/storm toggle`                   | Activa o desactiva la tormenta.                                                                   |
| `/storm status`                   | Muestra el estado actual de la tormenta, incluyendo el tiempo restante y el contador de muertes.  |
| `/storm reverse`                  | Reduce el tiempo de la tormenta basado en el contador de muertes.                                 |

## Estructura del Proyecto

```
src/main/java/me/ewahv1/plugin/
├── Commands
│   ├── CommandHandler.java
│   ├── CommandTabCompleter.java
│   └── Storm
│       ├── ResetStormCommand.java
│       ├── ReverseStormCommand.java
│       ├── SetBaseStormTimeCommand.java
│       ├── SetStormTimeCommand.java
│       ├── StormStatusCommand.java
│       └── ToggleStormCommand.java
├── CreateFiles
│   ├── InitialFilesManager.java
│   ├── InitialFilesSetup.java
│   └── JsonManager.java
├── Database
│   ├── DatabaseConfig.java
│   ├── DatabaseConnection.java
│   └── DatabaseSyncManager.java
├── Listeners
│   └── Storm
│       ├── StormListener.java
│       └── StormSettings.java
└── Main.java
```

## Contacto

Para cualquier consulta o problema, puedes contactarme en: M4pX_bc@hotmail.com

## Clonar el Repositorio

Para clonar este repositorio, utiliza el siguiente comando:

```
git clone https://github.com/GoldenShulkerStudios/StormPlugin.git
```
