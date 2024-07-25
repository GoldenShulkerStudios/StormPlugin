# StormPlugin

## Descripción

StormPlugin es un plugin para Minecraft que permite gestionar tormentas dentro del juego. El plugin ofrece diversas funcionalidades como activar y desactivar tormentas, ajustar el tiempo de duración de las tormentas, reiniciar valores de configuración y más. Este plugin es especialmente útil para servidores que buscan agregar un elemento de desafío y dinámica a la experiencia de juego mediante el uso de tormentas.

## Funcionalidades

- **Activar/Desactivar Tormentas**: Permite a los administradores del servidor activar o desactivar tormentas.
- **Configurar Tiempo Base de la Tormenta**: Ajusta el tiempo base de duración de las tormentas.
- **Revertir Tiempo de la Tormenta**: Permite reducir el tiempo de tormenta restante y ajustar el contador de muertes.
- **Reiniciar Configuración de la Tormenta**: Restaura los valores de configuración a los predeterminados.
- **Estado de la Tormenta**: Muestra el estado actual de la tormenta, incluyendo tiempo restante, tiempo base y contador de muertes.

## Comandos

### `/storm`

Comando principal para gestionar las tormentas. Uso:
- `/storm reset`: Restablece los valores de la tormenta a los predeterminados y detiene la tormenta.
- `/storm toggle`: Activa o desactiva la tormenta.
- `/storm status`: Muestra el estado actual de la tormenta.
- `/storm reverse`: Reduce el tiempo de la tormenta restante y ajusta el contador de muertes.
- `/storm set BaseTime <tiempo>`: Ajusta el tiempo base de la tormenta.
- `/storm set CurrentTime <tiempo>`: Ajusta el tiempo actual de la tormenta.

## Configuración

El plugin guarda y carga la configuración desde un archivo JSON llamado `StormConfig.json`. Este archivo contiene los siguientes parámetros:
- `RemainingStormTime`: Tiempo restante de la tormenta en segundos.
- `DefaultStormTime`: Tiempo base de duración de la tormenta en segundos.
- `StormActive`: Booleano que indica si la tormenta está activa.
- `PlayerDeathCounter`: Contador de muertes de jugadores durante la tormenta.

## Eventos

- **Muerte de Jugador**: Incrementa el contador de muertes y extiende el tiempo de tormenta.
- **Jugador se Une**: Muestra la barra de estado de la tormenta a los jugadores que se unen durante una tormenta.
- **Intento de Dormir**: Previene que los jugadores duerman durante una tormenta activa.

## Uso del Plugin

1. **Instalación**: Coloca el archivo del plugin en la carpeta `plugins` de tu servidor de Minecraft.
2. **Configuración Inicial**: El plugin creará automáticamente un archivo `StormConfig.json` en la carpeta de datos del plugin si no existe.
3. **Comandos**: Utiliza los comandos descritos anteriormente para gestionar las tormentas en tu servidor.

## Requisitos

- **Versión de Minecraft**: Compatible con la versión 1.21 de Minecraft.
- **Permisos**: Los comandos principales requieren permisos de operador (`op`) en el servidor.

## Contacto

Para más información, soporte o reportar errores, puedes contactar al desarrollador mediante un correo: [M4pX_bc@hotmail.com].

¡Disfruta de la dinámica adicional que StormPlugin trae a tu servidor de Minecraft!
