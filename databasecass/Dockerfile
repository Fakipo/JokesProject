# Use the official Cassandra image as the base, specifying the platform
FROM cassandra:latest

# Copy initialization scripts (optional)
COPY init-scripts/setup.cql docker-entrypoint-initdb.d/

# Expose necessary ports
EXPOSE 9042 7000 7001 7199

# Run Cassandra in the foreground
CMD ["cassandra", "-f"]
