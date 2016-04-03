/**
 * Copyright (C) 2014 4th Line GmbH, Switzerland and others
 *
 * The contents of this file are subject to the terms of the
 * Common Development and Distribution License Version 1 or later
 * ("CDDL") (collectively, the "License"). You may not use this file
 * except in compliance with the License. See LICENSE.txt for more
 * information.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 */

package org.jupnp.transport.spi;

import org.jupnp.model.ServerClientTokens;

import java.util.concurrent.ExecutorService;

/**
 * @author Christian Bauer
 */
public abstract class AbstractStreamClientConfiguration implements StreamClientConfiguration {

    protected ExecutorService requestExecutorService;
    protected int timeoutSeconds = 10;
    protected int logWarningSeconds = 5;

    protected AbstractStreamClientConfiguration(ExecutorService requestExecutorService) {
        this.requestExecutorService = requestExecutorService;
    }

    protected AbstractStreamClientConfiguration(ExecutorService requestExecutorService, int timeoutSeconds) {
        this.requestExecutorService = requestExecutorService;
        this.timeoutSeconds = timeoutSeconds;
    }

    protected AbstractStreamClientConfiguration(ExecutorService requestExecutorService, int timeoutSeconds, int logWarningSeconds) {
        this.requestExecutorService = requestExecutorService;
        this.timeoutSeconds = timeoutSeconds;
        this.logWarningSeconds = logWarningSeconds;
    }

    public ExecutorService getRequestExecutorService() {
        return requestExecutorService;
    }

    public void setRequestExecutorService(ExecutorService requestExecutorService) {
        this.requestExecutorService = requestExecutorService;
    }

    /**
     * @return Configured value or default of 60 seconds.
     */
    public int getTimeoutSeconds() {
        return timeoutSeconds;
    }

    public void setTimeoutSeconds(int timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
    }

    /**
     * @return Configured value or default of 5 seconds.
     */
    public int getLogWarningSeconds() {
        return logWarningSeconds;
    }

    public void setLogWarningSeconds(int logWarningSeconds) {
        this.logWarningSeconds = logWarningSeconds;
    }

    /**
     * @return Defaults to string value of {@link org.jupnp.model.ServerClientTokens}.
     */
    public String getUserAgentValue(int majorVersion, int minorVersion) {
        return new ServerClientTokens(majorVersion, minorVersion).toString();
    }
}