// FindByPhotoForm.js (AI 기반 실종자 찾기 폼 컴포넌트)
import React, { useState } from 'react';
import ApiService from '../services/ApiService';

const FindByPhotoForm = () => {
    const [photo, setPhoto] = useState(null);

    const handleFileChange = (e) => {
        setPhoto(e.target.files[0]);
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (!photo) return;

        try {
            const response = await ApiService.findMissingPersonByPhoto(photo);
            console.log(response); // 실종자 데이터를 처리하는 로직
        } catch (error) {
            console.error('Error finding missing person by photo:', error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <input type="file" onChange={handleFileChange} />
            <button type="submit">사진으로 실종자 찾기</button>
        </form>
    );
};

export default FindByPhotoForm;
