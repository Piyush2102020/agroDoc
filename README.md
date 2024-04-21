# AgroDoc

AgroDoc is a mobile application developed using Android Studio, Java, XML, Firebase, and Python. It leverages deep learning techniques using PyTorch to recommend crops based on various factors such as NPK (Nitrogen, Phosphorus, and Potassium) values, agro-climatic region, and soil type.

## Installation

1. Open the `agrodoc` folder in Android Studio and build the project.
2. Ensure Python and required dependencies are installed for the `crsapi` folder.

## Usage

1. Run the AgroDoc app on an Android device or emulator.
2. Input the required parameters such as NPK values, agro-climatic region, and soil type.
3. Click on the "Recommend Crops" button to view the recommended crops.

### Additional Scripts

- **filter.py**: Reads the `auth_data.csv` and multiplies the ratios to a range or number for data augmentation. Users can adjust this range according to their requirements.
- **agrodocmodel.py**: Contains a class to train the model on custom data for crop recommendation.
- **service.py**: Requires database URL and Firebase certificate to push the recommended crops to the database.

## Contributing

Contributions are welcome! If you'd like to contribute to AgroDoc, please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/my-feature`).
3. Make your changes.
4. Commit your changes (`git commit -am 'Add new feature'`).
5. Push to the branch (`git push origin feature/my-feature`).
6. Create a new Pull Request.


Note: The authentication data used in this project was provided from a research paper. The model was trained on this data to make crop recommendations. As of the latest evaluation, the model's loss was observed to be around 0.7 to 0.9.

