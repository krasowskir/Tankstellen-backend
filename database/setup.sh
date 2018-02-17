#!/bin/bash

host=localhost
user=postgres

psql -h $host -U $user < ./setupPostgresDb.sql


