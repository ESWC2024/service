// ApiService.js (API 통신을 담당하는 서비스)
const findMissingPersonByPhoto = async (photo) => {
    const formData = new FormData();
    formData.append('photo', photo);

    const response = await fetch('/api/missing-persons/find-by-photo', {
        method: 'POST',
        body: formData,
    });

    if (!response.ok) {
        throw new Error('Failed to find missing person by photo');
    }

    return response.json();
};

export default {
    findMissingPersonByPhoto,
};
