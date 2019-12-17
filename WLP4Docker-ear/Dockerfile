# Start with OL runtime.
# tag::from[]
FROM open-liberty
# end::from[]

#COPY --chown=1001:0 src/main/liberty/config/ /config/
COPY --chown=1001:0 target/liberty/wlp/ /wlp/
COPY --chown=1001:0 target/WLP4Docker-ear.ear /config/apps/WLP4Docker.ear

# tag::user-root[]
USER root
# end::user-root[]
# Symlink servers directory for easier mounts.
# tag::link[]
#EG RUN ln -s /opt/ol/wlp/usr/servers /servers
# end::link[]
# tag::user[]
#EG USER 1001
# end::user[]

# Run the server script and start the defaultServer by default.
# tag::entrypoint[]
#EG ENTRYPOINT ["/opt/ol/wlp/bin/server", "run"]
# end::entrypoint[]
# tag::default-start[]
#EG CMD ["WLP4DockerServer"]
# end::default-start[]


