create database controlAsistencia;
use controlAsistencia;

create table alumno(
	idAlumno int primary key auto_increment not null,
    nombreAlumno varchar(70) not null,
    apeAlumnoPat varchar(50) not null,
    apeAlumnoMat varchar(50) not null,
    matricula varchar(9) not null,
    repite boolean not null,
	asistencia int not null
);

create table docente(
	idDocente int primary key auto_increment not null,
    nombreDocente varchar(70) not null,
    apeDocentePat varchar(50) not null,
    apeDocenteMat varchar(50) not null,
    numDocente varchar(10) not null
);

create table experienciaEducativa(
	idExperiencia int primary key auto_increment not null,
    nombreExperiencia varchar(300) not null,
    nrc varchar(5)
)