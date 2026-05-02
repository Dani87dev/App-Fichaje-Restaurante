# Fichaje - Backend

Sistema de fichaje para restaurant. API REST desarrollada con Java + Spring Boot siguiendo arquitectura hexagonal.

---

## Descripción

Aplicación backend para gestionar el fichaje de personal de hostelería. Permite a los trabajadores registrar entrada y salida desde cualquier dispositivo, mientras el propietario controla horarios y jornadas desde un panel de administración.

Desarrollada como alternativa económica a herramientas de pago como Factorial.

---

## Tecnologías

- Java 17
- Spring Boot 3.5
- Spring Web (API REST)
- Spring Data JPA
- Spring Security + JWT
- PostgreSQL (producción)
- H2 (desarrollo/tests)
- Maven
- Lombok

---

## Arquitectura

Proyecto estructurado con **arquitectura hexagonal** (ports & adapters):

- **Domain** — Entidades y puertos (interfaces). Sin dependencias externas.
- **Application** — Casos de uso (services). Orquesta la lógica de negocio.
- **Infrastructure** — Adaptadores: controllers REST, repositorios JPA, seguridad JWT.

```
src/main/java/com/fichaje/
├── user/
│   ├── domain/
│   │   ├── model/          User, Rol, Sector
│   │   └── port/           UserRepository (interfaz)
│   ├── application/        UserService
│   └── infrastructure/
│       ├── persistence/    JPA entities y adaptadores
│       └── web/            Controllers REST
├── timerecord/
│   ├── domain/
│   │   ├── model/          TimeRecord
│   │   └── port/           TimeRecordRepository (interfaz)
│   ├── application/        TimeRecordService
│   └── infrastructure/
│       ├── persistence/    JPA entities y adaptadores
│       └── web/            Controllers REST
└── shared/
    └── infrastructure/
        └── security/       JWT, Spring Security config
```

---

## Funcionalidades

### Fase 1 — Base (actual)
- Autenticación con JWT (roles ADMIN / WORKER)
- CRUD de trabajadores
- Fichaje de entrada (clock-in) y salida (clock-out)
- Historial de fichajes

### Fase 2 — Gestión (pendiente)
- Cálculo automático de horas trabajadas y horas extra
- Resúmenes por día / semana / mes
- Exportación de informes en PDF y Excel
- Dashboard con estadísticas para el administrador

### Fase 3 — Gamificación (pendiente)
- Sistema de puntos por puntualidad, horas extra, cambios de turno
- Conversión de puntos en pluses económicos reales
- Panel personal del trabajador con objetivos

---

## Requisitos legales

Cumple con el RDL 8/2019 de registro horario obligatorio:

- Registro diario de entrada y salida de cada trabajador
- Conservación de registros durante 4 años
- Datos disponibles para trabajadores, sindicatos e Inspección de Trabajo
- Integridad y trazabilidad de los datos (registro de modificaciones)

---

## Requisitos

- Java 17+
- Maven 3.x
- Docker (para PostgreSQL en producción)

---

## Frontend

El frontend es un proyecto separado desarrollado con React. Consulta su repositorio para más información.

---

## Estado del proyecto

🟡 **En desarrollo** — MVP inicial del backend
