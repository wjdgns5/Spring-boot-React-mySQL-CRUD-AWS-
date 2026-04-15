import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import axiosInstance from "../api/axiosInstance";

function BoardEditPage() {
  const { id } = useParams();
  const navigate = useNavigate();

  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");

  useEffect(() => {
    getBoard();
  }, [id]);

  const getBoard = async () => {
    try {
      const res = await axiosInstance.get(`/api/boards/${id}`);
      setTitle(res.data.title);
      setContent(res.data.content);
    } catch (error) {
      console.error("게시글 불러오기 실패:", error);
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await axiosInstance.put(`/api/boards/${id}`, {
        title,
        content,
      });

      alert("수정 완료");
      navigate(`/boards/${id}`);
    } catch (error) {
      console.error("게시글 수정 실패:", error);
      alert("수정 실패");
    }
  };

  return (
    <div>
      <h2>게시글 수정</h2>

      <form onSubmit={handleSubmit}>
        <div>
          <input
            type="text"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
          />
        </div>

        <div>
          <textarea
            value={content}
            onChange={(e) => setContent(e.target.value)}
            rows="10"
            cols="50"
          />
        </div>

        <button type="submit">수정 완료</button>

        <button type="button" onClick={() => navigate("/boards")}>
          목록으로
        </button>
      </form>
    </div>
  );
}

export default BoardEditPage;
