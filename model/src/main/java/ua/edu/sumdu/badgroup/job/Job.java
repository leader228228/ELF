package ua.edu.sumdu.badgroup.job;

import ua.edu.sumdu.badgroup.exceptions.ELFException;

/**
 *  Any implementation of this interface must be able to execute a task parameters of which must be set prior the
 * method {@code execute} is invoked
 *  The
 * */
public interface Job <T> {
    T execute() throws ELFException;
}
