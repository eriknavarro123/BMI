📱 LladosBMI Calculator

Aplicación Android nativa, escrita en **Kotlin**, para calcular el **Índice de Masa Corporal (IMC / BMI)**. El usuario introduce su nombre, ajusta su peso con los botones `+` / `−` y obtiene su IMC en pantalla.

Proyecto desarrollado como práctica académica en el **INS Baix Camp**.
<img width="279" height="396" alt="image" src="https://github.com/user-attachments/assets/4028ac52-e7a4-48b3-b63e-5ca743c5bc92" />


1  Funcionalidades

- Campo de texto para introducir el **nombre** del usuario.
- Selector de **peso** con botones `+` y `−` (valor inicial: 80 kg).
- Botón **Calcular IMC** que muestra un saludo personalizado y el resultado.
- Interfaz basada en `CardView` con bordes redondeados y `ConstraintLayout`.
- Soporte de tema claro y oscuro (`values` / `values-night`).
- Edge-to-edge activado para aprovechar toda la pantalla.

2  Fórmula


IMC = \frac{peso\ (kg)}{altura\ (m)^2}


| IMC | Clasificación (OMS) |
|---|---|
| < 18,5 | Bajo peso |
| 18,5 – 24,9 | Peso normal |
| 25,0 – 29,9 | Sobrepeso |
| ≥ 30,0 | Obesidad |

3 🛠️ Tecnologías

| Componente | Detalle |
|---|---|
| Lenguaje | Kotlin |
| Plataforma | Android (`minSdk` 24, `targetSdk` / `compileSdk` 37) |
| Build | Gradle con Kotlin DSL + *version catalog* (`libs.versions.toml`) |
| UI | XML Views, `ConstraintLayout`, `CardView`, Material Components |
| Librerías | AndroidX Core KTX, AppCompat, Activity KTX |
| Tests | JUnit 4, Espresso |
| Java | Compatibilidad con Java 11 |

4 Estructura del proyecto

```
LladosBMICalculator/
├── app/
│   ├── build.gradle.kts
│   └── src/
│       ├── main/
│       │   ├── AndroidManifest.xml
│       │   ├── java/org/insbaixcamp/lladosbmicalculator/
│       │   │   └── MainActivity.kt        # Lógica de la pantalla principal
│       │   └── res/
│       │       ├── layout/activity_main.xml
│       │       ├── values/                # strings, colors, themes
│       │       └── values-night/          # tema oscuro
│       ├── test/                          # Tests unitarios
│       └── androidTest/                   # Tests instrumentados
├── gradle/
│   └── libs.versions.toml                 # Versiones de dependencias
├── build.gradle.kts
└── settings.gradle.kts
```

5 🚀 Puesta en marcha

 Requisitos

- [Android Studio](https://developer.android.com/studio) (versión reciente, compatible con AGP 9.x)
- JDK 11 o superior
- Un emulador o dispositivo físico con Android 7.0 (API 24) o superior

 Instalación

```bash
# 1. Clona el repositorio
git clone https://github.com/<tu-usuario>/LladosBMICalculator.git

# 2. Entra en la carpeta
cd LladosBMICalculator
```

3. Abre el proyecto en **Android Studio** (`File > Open`).
4. Espera a que Gradle sincronice las dependencias.
5. Pulsa **Run ▶️** para ejecutar la app en un emulador o dispositivo.

También puedes compilar desde la terminal:

```bash
./gradlew assembleDebug      # Genera el APK de depuración
./gradlew test               # Ejecuta los tests unitarios
```


6 🗺️ Estado del proyecto y próximos pasos

El proyecto se encuentra **en desarrollo**. Tareas pendientes:

- [ ] Enlazar correctamente los identificadores de las vistas entre `activity_main.xml` y `MainActivity.kt`.
- [ ] Mostrar el resultado del IMC y el saludo en la tarjeta inferior.
- [ ] Añadir un selector de **altura** (actualmente fijada en 1,80 m en el código).
- [ ] Mostrar la **clasificación** del IMC (bajo peso, normal, sobrepeso, obesidad).
- [ ] Redondear el resultado a 1–2 decimales.
- [ ] Mover los textos a `strings.xml` (internacionalización).
- [ ] Añadir tests unitarios para el cálculo del IMC.


7  Licencia

Proyecto con fines educativos. Si deseas publicarlo con una licencia concreta, añade un archivo `LICENSE` (por ejemplo, [MIT](https://choosealicense.com/licenses/mit/)).

8 Autor

**Erik Navarro Alvarez** — INS Baix Camp
