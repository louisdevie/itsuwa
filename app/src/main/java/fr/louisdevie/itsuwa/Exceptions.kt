package fr.louisdevie.itsuwa

import java.lang.Exception

abstract class ItsuwaException(message: String): Exception(message)

class DatabaseNotSetUpYetException: ItsuwaException("Attempt to access the database before setup")