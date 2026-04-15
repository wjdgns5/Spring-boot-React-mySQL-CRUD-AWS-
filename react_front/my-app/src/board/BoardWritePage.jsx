import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axiosInstance from "../api/axiosInstance";

function BoardWritePage() {
  const navigate = useNavigate();

  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await axiosInstance.post("/api/boards", {
        title,
        content,
      });

      alert("게시글 작성 완료");
      navigate("/boards");
    } catch (error) {
      console.error("게시글 작성 실패:", error);
      alert("게시글 작성 실패");
    }
  };

  return (
    <div>
      <h2>게시글 작성</h2>

      <form onSubmit={handleSubmit}>
        <div>
          <input
            type="text"
            placeholder="제목"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
          />
        </div>

        <div>
          <textarea
            placeholder="내용"
            value={content}
            onChange={(e) => setContent(e.target.value)}
            rows="10"
            cols="50"
          />
        </div>

        <button type="submit">등록</button>

        <button type="button" onClick={() => navigate("/boards")}>
          목록으로
        </button>
      </form>
    </div>
  );
}

export default BoardWritePage;
