#!/usr/bin/env bash

mvn clean checkstyle:check
mvn clean checkstyle:checkstyle-aggregate