import json

# Loop to create files from quoraan_31.json to quoraan_114.json
for i in range(1, 115):  # From 31 to 114 inclusive
    filename = f"Quoraan_{i}.java"

    # Example content for the JSON file (you can modify this part to fit your needs)
    content = {
        "id": i,
        "text": f"This is the content for quoraan_{i}"
    }

    # Write content to the JSON file
    with open(filename, 'w') as f:
        json.dump(content, f, indent=4)

    print(f"File {filename} created successfully.")
