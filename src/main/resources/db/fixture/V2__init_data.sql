INSERT INTO pokemon_detail (id, name, height, weight, sprite_url)
VALUES (1, 'Bulbasaur', 7, 69, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png'),
       (2, 'Ivysaur', 10, 130, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png'),
       (3, 'Venusaur', 20, 1000, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png'),
       (4, 'Charmander', 6, 85, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png'),
       (5, 'Charmeleon', 11, 190, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/5.png');

INSERT INTO type_entry (pokemon_id, slot, name, url)
VALUES (1, 1, 'Grass', 'https://pokeapi.co/api/v2/type/12/'),
       (1, 2, 'Poison', 'https://pokeapi.co/api/v2/type/4/'),
       (2, 1, 'Grass', 'https://pokeapi.co/api/v2/type/12/'),
       (2, 2, 'Poison', 'https://pokeapi.co/api/v2/type/4/'),
       (3, 1, 'Grass', 'https://pokeapi.co/api/v2/type/12/'),
       (3, 2, 'Poison', 'https://pokeapi.co/api/v2/type/4/'),
       (4, 1, 'Fire', 'https://pokeapi.co/api/v2/type/10/'),
       (5, 1, 'Fire', 'https://pokeapi.co/api/v2/type/10/');

