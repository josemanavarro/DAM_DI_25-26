FROM mysql:8.4

# Scripts de inicialización (DB, tablas, datos, grants…)
COPY --chown=mysql:mysql conf.d/*.cnf /etc/mysql/conf.d/
COPY --chown=mysql:mysql init/* /docker-entrypoint-initdb.d/

# Evita problemas de permisos en imágenes recientes
RUN find /etc/mysql/conf.d -type f -name '*.cnf' -exec chmod 644 {} \; \
 && find /docker-entrypoint-initdb.d -type f -exec chmod 644 {} \;

EXPOSE 3306
